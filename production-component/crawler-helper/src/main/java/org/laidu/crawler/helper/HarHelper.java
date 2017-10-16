package org.laidu.crawler.helper;

import org.laidu.crawler.helper.har.HarParser;
import org.laidu.crawler.helper.har.model.Har;
import org.laidu.crawler.helper.model.RequestInfo;
import org.laidu.crawler.helper.util.HarFilterUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * har praser help
 * <p>
 * Created by tiancai.zang on 2017-10-16 15:30.
 */
public class HarHelper {

    public static List<RequestInfo> parserRequestTrack(String harPath, String targetRequestUrl) {

        Har har = getHar(harPath);
        RequestInfo targetRequest = HarFilterUtil.getTargetRequest(har, targetRequestUrl).stream().findFirst().get();

        Map<String, String> targetCookieMap = targetRequest.getCookies();
        List<RequestInfo> cookieRequestTrack = new ArrayList<>();
        targetCookieMap.forEach((k, v) -> {
            List<RequestInfo> requestInfoList = HarFilterUtil.getTargetRequest(har, entries -> entries.response.cookies.stream().anyMatch(cookies -> k.equals(cookies.name) && v.equals(cookies.value)));
            if (!requestInfoList.isEmpty()) {
                cookieRequestTrack.addAll(requestInfoList);
            }

        });
        return cookieRequestTrack;

    }


    public static Har getHar(String harPath) {
        return HarParser.parseHar(harPath);
    }
}