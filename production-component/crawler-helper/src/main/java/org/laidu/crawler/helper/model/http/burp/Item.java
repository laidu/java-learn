package org.laidu.crawler.helper.model.http.burp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tiancai.zang
 * on 2018-04-11 17:02.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private String extension;

    private Response response;

    private String port;

    private String mimetype;

    private String time;

    private String protocol;

    private Host host;

    private String status;

    private Request request;

    private String path;

    private String method;

    private String responselength;

    private String comment;

    private String url;
}