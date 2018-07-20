package org.laidu.learn.wechat.common.config;

import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 微信支付配置
 * <p>
 * Created by laidu
 * on 2018-07-20 14:31.
 *
 * @author laidu
 */
@Slf4j
@Configuration
@Import(WechatPayImportSelector.class)
public class WechatPayConfiguration {


    @Autowired
    WechatPayProperties wechatPayProperties;

    @Bean
    public WxPayConfig payConfig() {
        WxPayConfig payConfig = new WxPayConfig();
        payConfig.setAppId(wechatPayProperties.getAppId());
        payConfig.setMchId(wechatPayProperties.getMchId());
        payConfig.setMchKey(wechatPayProperties.getMchKey());
        payConfig.setSubAppId(wechatPayProperties.getSubAppId());
        payConfig.setSubMchId(wechatPayProperties.getSubAppId());
        payConfig.setKeyPath(wechatPayProperties.getKeyPath());

        return payConfig;
    }

    @Bean
    public WxPayService payService() {
        WxPayService payService = new WxPayServiceImpl();
        payService.setConfig(payConfig());
        return payService;
    }
}