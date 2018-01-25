package org.laidu.crawler.helper.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.List;

/**
 * crawler request and reponse
 * <p>
 * Created by tiancai.zang on 2017-12-13 11:19.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
// : 2017/12/13 11/19 crawler request and reponse
public class CrawlerSite {

    private String siteNameZh;

    private String curl;

    private Params params;

    private Encryptions encryptions;

    private Response responses;


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Params{
        private List<CrawlerRequestParam> param;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Encryptions {
        private List<Encryption> encryption;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {

        private String responseType;

        private List<CrawlerResponse> response;
    }

}