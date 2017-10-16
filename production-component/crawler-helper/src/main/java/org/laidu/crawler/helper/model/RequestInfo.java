package org.laidu.crawler.helper.model;

import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * request info
 * <p>
 * Created by tiancai.zang on 2017-10-16 15:19.
 */
@Slf4j
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestInfo {

    /**
     * request index
     */
    private int index;

    private String url;

    private String method;

    private String charset;

    private HttpRequestBody requestBody;

    /**
     * Store additional information in extras.
     */
    private Map<String, Object> extras;

    /**
     * cookies for current url, if not set use Site's cookies
     */
    private Map<String, String> cookies = new HashMap<String, String>();

    private Map<String, String> headers = new HashMap<String, String>();
}