package org.laidu.learn.spring.cloud.stream;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

/**
 * spring cloud stream learn
 */

@EnableBinding({Sink.class, Source.class})
@SpringBootApplication
public class StreamApp {

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("一般监听收到：" + message.getPayload());
    }

    public static void main(String[] args) {

        new SpringApplicationBuilder(StreamApp.class)
                .bannerMode(Banner.Mode.OFF)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
