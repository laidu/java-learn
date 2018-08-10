package org.laidu.learn.spring.boot.sso;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * sso 启动类
 *
 * @author tiancai.zang
 * on 2018-08-10 18:54.
 */
// TODO: 2018-08-10 18:54  sso 启动类
@Slf4j
@SpringBootApplication
@EnableOAuth2Sso
public class SSOApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SSOApp.class)
                .logStartupInfo(false)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}