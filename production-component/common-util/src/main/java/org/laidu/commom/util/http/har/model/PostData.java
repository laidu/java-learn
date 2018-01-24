package org.laidu.commom.util.http.har.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * postdata
 * <p>
 * Created by 臧天才 on 2017-08-14 17:40.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostData {

    /**
     * mimeType : application/x-www-form-urlencoded; charset=UTF-8
     * text : m=checkphone&phone=18932911274
     * params : [{"name":"m","value":"checkphone"},{"name":"phone","value":"18932911274"}]
     */

    private String mimeType;
    private String text;
    /**
     * name : m
     * value : checkphone
     */
    private List<ParamsBean> params;

    @Data
    public static class ParamsBean {
        private String name;
        private String value;
    }
}
