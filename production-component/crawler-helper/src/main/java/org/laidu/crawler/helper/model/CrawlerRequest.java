package org.laidu.crawler.helper.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
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
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
// : 2017/12/13 11/19 crawler request and reponse
public class CrawlerRequest {

    private String curl;

    private String requestNameZh;

    private Params params;

    private EncryptionFileds encryptionFileds;

    private Responses responses;


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
    public static class EncryptionFileds{
        private List<EncryptionFiled> encryptionFiled;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Responses{
        private List<CrawlerResponse> response;
    }

}