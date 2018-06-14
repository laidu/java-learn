package org.laidu.crawler.helper.model.http.burp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * burp site items
 * <p>
 * Created by tiancai.zang
 * on 2018-04-11 16:39.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BurpSiteItem {

    private Items items;
}