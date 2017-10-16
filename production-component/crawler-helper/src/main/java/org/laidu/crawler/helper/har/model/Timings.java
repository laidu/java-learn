package org.laidu.crawler.helper.har.model;
import lombok.Data;
@Data
public class Timings {
    public int blocked;
    public int dns;
    public int connect;
    public int ssl;
    public int send;
    public int wait;
    public int receive;
}
