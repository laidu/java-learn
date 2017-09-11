package org.laidu.learn.async.http.client.demo;


import lombok.extern.slf4j.Slf4j;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Request;
import org.asynchttpclient.Response;
import org.asynchttpclient.request.body.multipart.Part;
import org.asynchttpclient.request.body.multipart.StringPart;

import static org.asynchttpclient.Dsl.asyncHttpClient;
import static org.asynchttpclient.Dsl.post;

/**
 * Usage
 * <p>
 * Created by 臧天才 on 2017-09-11 20:02.
 */
@Slf4j
// TODO : 2017-09-11 20:02  Usage
public class Usage {

    public static void main(String[] args) throws Exception{

        Part part = new StringPart("niad","hah");

        Request request = post("http://127.0.0.1:8080").addBodyPart(part).build();


        try(AsyncHttpClient asyncHttpClient = asyncHttpClient()) {

            asyncHttpClient
                    .prepareRequest(request)
                    .execute()
                    .toCompletableFuture()
                    .thenApply(Response::getResponseBody)
                    .thenAccept(System.out::println)
                    .join();

        }

    }
}
