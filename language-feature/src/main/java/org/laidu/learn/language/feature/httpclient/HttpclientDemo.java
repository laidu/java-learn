package org.laidu.learn.language.feature.httpclient;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * java 11 http client demo
 *
 * @since java 11
 * @author tiancai.zang
 * on 2018-10-09 14:21.
 */
@Slf4j
public class HttpclientDemo {


    public static void main(String[] args) throws IOException, InterruptedException {


        String url = "https://api.github.com";

        HttpClient client = HttpClient.newBuilder()
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println);


        Thread.sleep(2000);


    }

}