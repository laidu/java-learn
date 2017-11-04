package org.laidu.commom.util.http.har;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.laidu.commom.util.http.har.model.Har;

@Slf4j
public class HarParser {

    private CrawlerRequestTrack crawlerRequestTrack;

    public static Har parseHar(String harFile) {
        return new Gson().fromJson(harFile, Har.class);
    }

}
