package org.laidu.learn.wechat.common.controller;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.oauth2.WxOAuth2AccessToken;
import me.chanjar.weixin.common.error.WxErrorException;
//import me.chanjar.weixin.mp.AiLangType;
//import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.enums.AiLangType;

import org.apache.commons.lang3.StringUtils;
import org.laidu.learn.wechat.common.service.CoreService;
import org.laidu.learn.wechat.common.util.ReturnModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by FirenzesEagle on 2016/5/30 0030.
 * Email:liumingbo2008@gmail.com
 */
@Slf4j
@RequestMapping("/")
@Controller
public class CoreController extends GenericController {

    private final WxMpConfigStorage configStorage;
    private final WxMpService wxMpService;
    private final CoreService coreService;

    private final StringRedisTemplate redisTemplate;

    @Value("${msgQueueKey:msg}")
    private String msgQueueKey;

    @Autowired
    public CoreController(WxMpConfigStorage configStorage, WxMpService wxMpService, CoreService coreService, StringRedisTemplate redisTemplate) {
        this.configStorage = configStorage;
        this.wxMpService = wxMpService;
        this.coreService = coreService;
        this.redisTemplate = redisTemplate;
    }

    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }

    /**
     * 微信公众号webservice主服务接口，提供与微信服务器的信息交互
     */
    @RequestMapping(value = "/core")
    public void wechatCore(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        String signature = request.getParameter("signature");
        String nonce = request.getParameter("nonce");
        String timestamp = request.getParameter("timestamp");

        if (!this.wxMpService.checkSignature(timestamp, nonce, signature)) {
            // 消息签名不正确，说明不是公众平台发过来的消息
            response.getWriter().println("非法请求");
            return;
        }

        String echoStr = request.getParameter("echostr");
        if (StringUtils.isNotBlank(echoStr)) {
            // 说明是一个仅仅用来验证的请求，回显echostr
            String echoStrOut = String.copyValueOf(echoStr.toCharArray());
            response.getWriter().println(echoStrOut);
            return;
        }

        String encryptType = StringUtils.isBlank(request.getParameter("encrypt_type"))
            ? "raw"
            : request.getParameter("encrypt_type");

        if ("raw".equals(encryptType)) {
            // 明文传输的消息
            WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(request.getInputStream());
            WxMpXmlOutMessage outMessage = this.coreService.route(inMessage);
            if (outMessage == null) {
                response.getWriter().write("");
            } else {
                String openid = inMessage.getFromUser();
                WxMpUser wxMpUser = this.wxMpService.getUserService().userInfo(openid, "zh_CN");

                String msg = inMessage.getContent() ;
                if (WxConsts.MassMsgType.VOICE.equals(inMessage.getMsgType())) {
                    msg =  wxMpService.getAiOpenService().queryRecognitionResult(inMessage.getMediaId(), AiLangType.zh_CN);
                }
                if (!"【收到不支持的消息类型，暂无法显示】".equals(msg)) {
                    redisTemplate.opsForList().leftPush(msgQueueKey,"来自用户 "+wxMpUser.getNickname()+" : " + msg);
                }


                response.getWriter().write(outMessage.toXml());
            }
            return;
        }

        if ("aes".equals(encryptType)) {
            // 是aes加密的消息
            String msgSignature = request.getParameter("msg_signature");
            WxMpXmlMessage inMessage = WxMpXmlMessage.fromEncryptedXml(
                request.getInputStream(), this.configStorage, timestamp, nonce,
                msgSignature);
            this.logger.debug("\n消息解密后内容为：\n{} ", inMessage.toString());
            WxMpXmlOutMessage outMessage = this.coreService.route(inMessage);
            if (outMessage == null) {
                response.getWriter().write("");
            } else {
                response.getWriter().write(outMessage.toEncryptedXml(this.configStorage));
            }

            return;
        }

        response.getWriter().println("不可识别的加密类型");
    }

    /**
     * 通过openid获得基本用户信息
     * 详情请见: http://mp.weixin.qq.com/wiki/14/bb5031008f1494a59c6f71fa0f319c66.html
     *
     * @param openid openid
     * @param lang   zh_CN, zh_TW, en
     */
    @RequestMapping(value = "/getUserInfo")
    public WxMpUser getUserInfo(HttpServletResponse response, @RequestParam(value = "openid") String openid, @RequestParam(value = "lang") String lang) {
        ReturnModel returnModel = new ReturnModel();
        WxMpUser wxMpUser = null;
        try {
            wxMpUser = this.wxMpService.getUserService().userInfo(openid, lang);
            returnModel.setResult(true);
            returnModel.setDatum(wxMpUser);
            renderString(response, returnModel);
        } catch (WxErrorException e) {
            returnModel.setResult(false);
            returnModel.setReason(e.getError().toString());
            renderString(response, returnModel);
            this.logger.error(e.getError().toString());
        }
        return wxMpUser;
    }

    /**
     * 通过code获得基本用户信息
     * 详情请见: http://mp.weixin.qq.com/wiki/14/bb5031008f1494a59c6f71fa0f319c66.html
     *
     * @param code code
     * @param lang zh_CN, zh_TW, en
     */
    @RequestMapping(value = "/getOAuth2UserInfo")
    public void getOAuth2UserInfo(HttpServletResponse response, @RequestParam(value = "code") String code, @RequestParam(value = "lang") String lang) {
        ReturnModel returnModel = new ReturnModel();
        WxOAuth2AccessToken accessToken;
        WxMpUser wxMpUser;
        try {
            accessToken = this.wxMpService.getOAuth2Service().getAccessToken(code);
            wxMpUser = this.wxMpService.getUserService()
                .userInfo(accessToken.getOpenId(), lang);
            returnModel.setResult(true);
            returnModel.setDatum(wxMpUser);
            renderString(response, returnModel);
        } catch (WxErrorException e) {
            returnModel.setResult(false);
            returnModel.setReason(e.getError().toString());
            renderString(response, returnModel);
            this.logger.error(e.getError().toString());
        }
    }

    /**
     * 用code换取oauth2的openid
     * 详情请见: http://mp.weixin.qq.com/wiki/1/8a5ce6257f1d3b2afb20f83e72b72ce9.html
     *
     * @param code code
     */
    @RequestMapping(value = "/getOpenid")
    public void getOpenid(HttpServletResponse response, @RequestParam(value = "code") String code) {
        ReturnModel returnModel = new ReturnModel();
        WxOAuth2AccessToken accessToken;
        try {
            accessToken = this.wxMpService.getOAuth2Service().getAccessToken(code);
            returnModel.setResult(true);
            returnModel.setDatum(accessToken.getOpenId());
            renderString(response, returnModel);
        } catch (WxErrorException e) {
            returnModel.setResult(false);
            returnModel.setReason(e.getError().toString());
            renderString(response, returnModel);
            this.logger.error(e.getError().toString());
        }
    }

}
