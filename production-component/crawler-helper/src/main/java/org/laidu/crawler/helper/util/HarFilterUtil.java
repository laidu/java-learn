package org.laidu.crawler.helper.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.laidu.crawler.helper.har.model.*;
import org.laidu.crawler.helper.model.RequestInfo;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * har filter
 * <p>
 * Created by tiancai.zang on 2017-10-16 15:41.
 */
@Slf4j
public class HarFilterUtil {


    public static List<RequestInfo> getTargetRequest(Har har, String targetUrl){
        return getTargetRequest(har,entries -> targetUrl.equals(entries.request.url));
    }

    public static List<RequestInfo> getTargetRequest(Har har, Predicate<Entries> requestInfoPredicate){

        return har.getLog().entries.stream().filter(requestInfoPredicate).map(HarFilterUtil::convert2RequestInfo).collect(Collectors.toList());
    }

    public static List<RequestInfo> convert2RequestInfoList(List<Entries> entries){
        return entries.stream().map(HarFilterUtil::convert2RequestInfo).collect(Collectors.toList());
    }

    public static RequestInfo convert2RequestInfo(Entries entries){

        Request request = entries.request;

        return RequestInfo.builder()
                .url(request.url)
                .method(request.method)
                .headers(request.headers.stream().collect(Collectors.toMap(Headers::getName,Headers::getValue)))
                .cookies(request.cookies.stream().collect(Collectors.toMap(Cookies::getName,Cookies::getValue)))
                .build();
    }



}