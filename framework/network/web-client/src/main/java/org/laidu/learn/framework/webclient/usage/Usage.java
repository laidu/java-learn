package org.laidu.learn.framework.webclient.usage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * 使用
 * <p>
 * Created by laidu
 * on 2018-08-06 14:10.
 *
 * @author laidu
 */
@Slf4j
public class Usage {



    public static void main(String[] args) throws InterruptedException {


       WebClient.create()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("api.github.com")
                        .path("/users/laidu")
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(resp -> log.info(": {}", resp));


    }

}