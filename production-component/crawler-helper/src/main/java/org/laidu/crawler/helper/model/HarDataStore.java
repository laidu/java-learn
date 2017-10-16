package org.laidu.crawler.helper.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * har data store
 * <p>
 * Created by tiancai.zang on 2017-10-16 15:36.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HarDataStore {

    private Map<String,Map<String,String>> cookieMap;

    private Map<String,Map<String,String>> requestParamMap;
}