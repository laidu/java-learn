package org.laidu.crawler.helper.har.model;
import lombok.Data;
import java.util.List;

@Data
public class Log {

    public String version;
    public Creator creator;
    public List<Pages> pages;
    public Browser browser;
    public List<Entries> entries;
}
