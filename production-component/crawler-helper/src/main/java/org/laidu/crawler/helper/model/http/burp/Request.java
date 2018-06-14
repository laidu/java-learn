package org.laidu.crawler.helper.model.http.burp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tiancai.zang
 * on 2018-04-11 17:03.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Request {

    private String content;

    private String base64;

}