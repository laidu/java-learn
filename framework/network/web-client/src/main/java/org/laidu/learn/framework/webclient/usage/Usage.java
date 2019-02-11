package org.laidu.learn.framework.webclient.usage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.stream.IntStream;

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



    public static void main(String[] args) {

        IntStream.range(0,1000).parallel()
                .forEach(index->{
                    log.info("index : {}", index);
                    WebClient.create()
                            .get()
                            .uri(uriBuilder -> uriBuilder
                                    .scheme("http")
                                    .host("www.baidu.com")
                                    .path("/s")
                                    .queryParam("wd", "北京天气")
                                    .queryParam("other", "test")
                                    .build())
                            .retrieve()
                            .bodyToMono(String.class)
                            .subscribe(resp -> log.info(": {}", resp));
                });



    }

}