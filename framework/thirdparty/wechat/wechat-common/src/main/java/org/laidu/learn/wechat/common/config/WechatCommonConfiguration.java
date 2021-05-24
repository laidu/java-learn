package org.laidu.learn.wechat.common.config;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * wechat 配置
 * <p>
 * Created by laidu
 * on 2018-07-20 14:12.
 *
 * @author laidu
 */
@Slf4j
@Configuration
@Import(WechatCommonImportSelector.class)
public class WechatCommonConfiguration {


    @Autowired
    WechatProperties wechatProperties;

    @Bean
    public WxMpConfigStorage wxMpConfigStorage() {
        WxMpDefaultConfigImpl configStorage = new WxMpDefaultConfigImpl();
        configStorage.setAppId(wechatProperties.getAppId());
        configStorage.setSecret(wechatProperties.getAppSecret());
        configStorage.setToken(wechatProperties.getToken());
        configStorage.setAesKey(wechatProperties.getAesKey());
        return configStorage;

    }

    @Bean
    public WxMpService wxMpService() {
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return wxMpService;
    }
}