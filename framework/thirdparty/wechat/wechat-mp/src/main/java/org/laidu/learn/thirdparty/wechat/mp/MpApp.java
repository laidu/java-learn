package org.laidu.learn.thirdparty.wechat.mp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 微信公众号
 * <p>
 * Created by laidu
 * on 2018-07-20 13:51.
 *
 * @author laidu
 */
@Slf4j
public class MpApp {

    public static void main(String[] args) {


        new SpringApplicationBuilder(MpApp.class)
                .bannerMode(Banner.Mode.OFF)
                .logStartupInfo(false)
                .run(args);

    }
}