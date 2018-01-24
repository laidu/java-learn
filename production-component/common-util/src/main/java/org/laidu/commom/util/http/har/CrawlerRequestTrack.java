package org.laidu.commom.util.http.har;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.laidu.commom.util.http.har.model.Entries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请求轨迹
 * <p>
 * Created by 臧天才 on 2017-08-15 14:49.
 */
@Slf4j
@Data
public class CrawlerRequestTrack {

    /**
     * 生成cookie 的请求
     */
    private final Map<String,List<Entries>> cookieProducerMap = new HashMap<>();

    /**
     * 目标url
     */
    private String targetRequestUrl;

    /**
     * 请求包含的cookies信息
     */
    private final List<String> requestCookieList = new ArrayList<>();

    /**
     * 由response 产生的 cookies信息
     */
    private final List<String> cookieList = new ArrayList<>();

    /**
     * 由response 产生的 cookies信息
     */
    private final List<String> otherCookieList = new ArrayList<>();

}
