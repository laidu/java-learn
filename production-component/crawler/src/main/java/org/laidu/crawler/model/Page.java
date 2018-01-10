package org.laidu.crawler.model;

import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Json;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;
import java.util.Map;

/**
 * @author tiancai.zang
 * 2018-01-10 17:08.
 */
public interface Page {
    us.codecraft.webmagic.Page setSkip(boolean skip);

    Html getHtml();

    Json getJson();

    void addTargetRequests(List<String> requests);

    void addTargetRequests(List<String> requests, long priority);

    void addTargetRequest(String requestString);

    void addTargetRequest(Request request);

    Selectable getUrl();

    Request getRequest();

    int getStatusCode();

    String getRawText();

    Map<String, List<String>> getHeaders();

    boolean isDownloadSuccess();

    byte[] getBytes();

    String getCharset();
}