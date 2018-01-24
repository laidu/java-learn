package org.laidu.commom.util.http.core;

import lombok.extern.slf4j.Slf4j;

/**
 * http method
 * <p>
 * Created by tiancai.zang on 2017-11-04 13:25.
 */
@Slf4j
public class HttpMethod {

    public final String HTTP_GET = "GET";
    public final String HTTP_HEADER = "HEADER";
    public final String HTTP_POST = "POST";
    public final String HTTP_DELETE = "DELETE";
    public final String HTTP_TRACE = "TRACE";
    public final String HTTP_PATCH = "PATCH";
    public final String HTTP_CONNECT = "CONNECT";
    public final String HTTP_OPTIONS = "OPTIONS";

    private HttpMethod() {
    }

    public static HttpMethod method(){
        return Method.method;
    }

    private static class Method {
        public static HttpMethod method = new HttpMethod();
    }
}