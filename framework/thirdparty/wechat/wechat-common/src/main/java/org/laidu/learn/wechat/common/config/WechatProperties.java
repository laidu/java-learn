package org.laidu.learn.wechat.common.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 微信配置
 * <p>
 * Created by laidu
 * on 2018-07-20 14:14.
 *
 * @author laidu
 */

@Data
@Configuration
@AutoConfigurationPackage
@ConfigurationProperties(prefix = "wechat")
public class WechatProperties {

    private String appId;

    private String appSecret;

    private String token;

    private String aesKey;

}