package org.laidu.learn.wechat.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 微信支付设置
 * <p>
 * Created by laidu
 * on 2018-07-20 14:32.
 *
 * @author laidu
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "wechat.pay")
public class WechatPayProperties {


    private String appId;

    private String mchId;

    private String mchKey;

    private String subAppId;

    private String subMchId;

    private String keyPath;


}