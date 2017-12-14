package org.laidu.crawler.helper.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * crawler response
 * <p>
 * Created by tiancai.zang on 2017-12-13 11:28.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
// : 2017/12/13 11/28 crawler response
public class CrawlerResponse {
    private String responseName;
    private String responseSource;
    private String attentionField;
    private String attentionFieldValue;
}