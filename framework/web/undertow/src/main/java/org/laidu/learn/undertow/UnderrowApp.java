package org.laidu.learn.undertow;

import io.undertow.Undertow;
import io.undertow.util.Headers;
import lombok.extern.slf4j.Slf4j;

/**
 * 嵌入式undertow 使用
 *
 * @author zangtiancai.
 * @date 2019-05-23 14:23.
 */
@Slf4j
public class UnderrowApp {

    public static void main(String[] args) {

        Undertow server = Undertow.builder()
                .addHttpListener(8080, "0.0.0.0")
                .setWorkerThreads(1)
                .setIoThreads(1)
                .setHandler(exchange -> {
                    exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                    exchange.getResponseSender().send("Hello World");
                    Thread.sleep(1000000);
                }).build();
        server.start();
    }
}
