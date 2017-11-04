package org.laidu.commom.util.http.core;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * http request
 * <p>
 * Created by tiancai.zang on 2017-11-04 13:17.
 */
@Slf4j
@Data
@Builder
public class HttpRequest implements Serializable {

    private static final long serialVersionUID = 2062192774891352043L;

    public static final String CYCLE_TRIED_TIMES = "_cycle_tried_times";

    private String url;

    private String method;

    private HttpRequestBody requestBody;

    /**
     * Store additional information in extras.
     */
    private Map<String, Object> extras;

    /**
     * cookies for current url, if not set use Site's cookies
     */
    private Map<String, String> cookies = new HashMap<>();

    private Map<String, String> headers = new HashMap<>();

    private long priority;

    private boolean binaryContent = false;

    private String charset;

    private HttpRequest() {
    }

    public static HttpRequest post(String url) {
        return HttpRequest.builder().url(url).method(HttpMethod.method().HTTP_POST).build();
    }

    public static HttpRequest get(String url) {
        return HttpRequest.builder().url(url).method(HttpMethod.method().HTTP_GET).build();
    }

    public Object getExtra(String key) {
        if (extras == null) {
            return null;
        }
        return extras.get(key);
    }

    public HttpRequest putExtra(String key, Object value) {
        if (extras == null) {
            extras = new HashMap<>();
        }
        extras.put(key, value);
        return this;
    }

    public String getHeader(String key) {
        return headers.get(key);
    }

    public HttpRequest putHeader(String key, String value) {
        headers.put(key, value);
        return this;
    }

    public String getCookie(String key) {
        return headers.get(key);
    }

    public HttpRequest putCookie(String key, String value) {
        headers.put(key, value);
        return this;
    }


    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (method != null ? method.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HttpRequest request = (HttpRequest) o;

        if (url != null ? !url.equals(request.url) : request.url != null) return false;
        return method != null ? method.equals(request.method) : request.method == null;
    }

    @Override
    public String toString() {
        return "Request{" +
                "url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", extras=" + extras +
                ", priority=" + priority +
                ", headers=" + headers +
                ", cookies="+ cookies+
                '}';
    }

}