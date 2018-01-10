package org.laidu.crawler.request;

import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.utils.HttpConstant;

/**
 * request builder
 *
 * @author tiancai.zang
 * 2018-01-09 17:06.
 */
// : 2018-01-09 17:06  request builder
public class RequestBuilder {

    public static Request buildRequest(String url,String method){
        Request request = new Request(url);
        request.setMethod(method);
        return request;
    }

    public static Request post(String url){
        return buildRequest(url,HttpConstant.Method.POST);
    }

    public static Request get(String url){
        return buildRequest(url,HttpConstant.Method.GET);
    }
}