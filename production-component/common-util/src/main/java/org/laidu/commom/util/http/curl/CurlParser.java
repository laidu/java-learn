package org.laidu.commom.util.http.curl;

import lombok.extern.slf4j.Slf4j;
import org.laidu.commom.util.http.core.HttpRequest;

/**
 * curl command line parser
 * <p>
 * Created by tiancai.zang on 2017-11-04 13:09.
 */
@Slf4j
public class CurlParser {

    public HttpRequest parser(String curlCommand){

        HttpRequest httpRequest = HttpRequest.builder().build();


        return httpRequest;
    }


    public static void main(String[] args) {


    }
}