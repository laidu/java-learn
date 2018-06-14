package org.laidu.crawler.helper.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.List;

/**
 * encrtption field
 * <p>
 * Created by tiancai.zang on 2017-12-13 11:24.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
// : 2017/12/13 11/24 encrtption field
public class Encryption {

    private String encryptionFiled;

    private String encryptionSource;

    private String encryptionAlgorithm;

    private EncryptionExtendParams encryptionExtendParams;


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class EncryptionExtendParams {
        private List<Extend> encryptionExtendParam;
    }


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Extend{
        @XmlAttribute
        private String name;
        @XmlAttribute
        private String value;

    }


}