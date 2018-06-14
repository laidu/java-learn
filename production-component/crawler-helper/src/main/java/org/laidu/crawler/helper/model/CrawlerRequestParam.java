package org.laidu.crawler.helper.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * crawler request params
 * <p>
 * Created by tiancai.zang on 2017-12-13 11:32.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
// : 2017/12/13 11/32 crawler request params
@XmlAccessorType(XmlAccessType.FIELD)
public class CrawlerRequestParam {

    @XmlAttribute
    private String name;
    @XmlAttribute
    private String value;
}