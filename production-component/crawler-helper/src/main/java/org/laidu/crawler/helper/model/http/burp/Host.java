package org.laidu.crawler.helper.model.http.burp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * host
 * <p>
 * Created by tiancai.zang
 * on 2018-04-11 16:57.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Host {

    private String content;
    private String ip;
}