package org.laidu.crawler.helper.har.model;
import lombok.Data;
@Data
public class PageTimings {

    public int onLoad;
    public int onContentLoad;
    public int _startRender;
}
