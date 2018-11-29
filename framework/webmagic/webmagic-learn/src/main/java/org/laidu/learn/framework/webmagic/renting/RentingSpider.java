package org.laidu.learn.framework.webmagic.renting;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.framework.webmagic.renting.conf.RequirementConf;
import org.laidu.learn.framework.webmagic.renting.processor.ziroom.ZiroomPageProcessor;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 租房信息爬取启动类
 *
 * @author tiancai.zang
 * on 2018-11-29 17:12.
 */
@Slf4j
public class RentingSpider extends Spider {

    /**
     * create a spider with pageProcessor.
     *
     * @param pageProcessor pageProcessor
     */
    public RentingSpider(PageProcessor pageProcessor) {
        super(pageProcessor);
    }

    public static void main(String[] args) {

        RequirementConf conf = RequirementConf.builder().build();

        RentingSpider spider = new RentingSpider(new ZiroomPageProcessor(conf));

        Spider.create(new ZiroomPageProcessor(conf)).addRequest(new Request("http://www.ziroom.com/z/nl/z2-r1.html")).start();

    }
}