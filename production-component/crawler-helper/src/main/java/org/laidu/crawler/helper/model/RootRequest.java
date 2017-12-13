package org.laidu.crawler.helper.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * request root
 * <p>
 * Created by tiancai.zang on 2017-12-13 13:53.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
// : 2017/12/13 13/53 request root
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "requests")
public class RootRequest {
    @XmlElement(name = "request")
    private List<CrawlerRequest> request;


}