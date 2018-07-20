package org.laidu.learn.wechat.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 微信通用模块
 * <p>
 * Created by laidu
 * on 2018-07-20 14:06.
 *
 * @author laidu
 */
@Slf4j
@SpringBootApplication
public class WechatCommonApp {


    public static void main(String[] args) {

        new SpringApplicationBuilder(WechatCommonApp.class)
                .bannerMode(Banner.Mode.OFF)
                .logStartupInfo(false)
                .run(args);
    }
}