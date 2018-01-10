package org.laidu.crawler.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Json;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;
import java.util.Map;

/**
 * page proxy
 *
 * @author tiancai.zang
 * 2018-01-10 17:00.
 */
@AllArgsConstructor
public class PageProxy implements Page {

    @Getter
    private final us.codecraft.webmagic.Page page;

    @Override
    public us.codecraft.webmagic.Page setSkip(boolean skip) {
        return page.setSkip(skip);
    }

    @Override
    public Html getHtml() {
        return page.getHtml();
    }

    @Override
    public Json getJson() {
        return page.getJson();
    }

    @Override
    public void addTargetRequests(List<String> requests) {
        page.addTargetRequests(requests);
    }

    @Override
    public void addTargetRequests(List<String> requests, long priority) {
        page.addTargetRequests(requests,priority);
    }

    @Override
    public void addTargetRequest(String requestString) {
        page.addTargetRequest(requestString);
    }

    @Override
    public void addTargetRequest(Request request) {
        page.addTargetRequest(request);
    }

    @Override
    public Selectable getUrl() {
        return page.getUrl();
    }

    @Override
    public Request getRequest() {
        return page.getRequest();
    }

    @Override
    public int getStatusCode() {
        return page.getStatusCode();
    }

    @Override
    public String getRawText() {
        return page.getRawText();
    }

    @Override
    public Map<String, List<String>> getHeaders() {
        return page.getHeaders();
    }

    @Override
    public boolean isDownloadSuccess() {
        return page.isDownloadSuccess();
    }

    @Override
    public byte[] getBytes() {
        return page.getBytes();
    }

    @Override
    public String getCharset() {
        return page.getCharset();
    }
}