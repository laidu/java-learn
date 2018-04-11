package org.laidu.crawler.helper.model.http.burp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Items
 * <p>
 * Created by tiancai.zang
 * on 2018-04-11 17:01.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Items {

    private String burpVersion;

    private String exportTime;

    private Item item;

}