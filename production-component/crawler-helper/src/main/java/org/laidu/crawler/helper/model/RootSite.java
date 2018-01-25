package org.laidu.crawler.helper.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * request root
 * <p>
 *
 * @author tiancai.zang
 * @date 2017-12-13 13:53
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "sites")
public class RootSite {

    protected List<CrawlerSite> site;
}