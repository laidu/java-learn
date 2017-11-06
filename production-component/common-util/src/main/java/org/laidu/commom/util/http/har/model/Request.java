package org.laidu.commom.util.http.har.model;

import java.util.List;

public class Request {
    public long index;
    public String method;
    public String url;
    public int headersSize;
    public int bodySize;
    public List<Cookies> cookies;
    public List<Headers> headers;
    public String httpVersion;
    public List<QueryString> queryString;
    public PostData postData;
}
