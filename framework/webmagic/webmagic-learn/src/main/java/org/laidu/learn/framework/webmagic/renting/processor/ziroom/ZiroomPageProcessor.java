package org.laidu.learn.framework.webmagic.renting.processor.ziroom;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.framework.webmagic.renting.conf.RequirementConf;
import org.laidu.learn.framework.webmagic.renting.entity.HouseInfo;
import org.laidu.learn.framework.webmagic.renting.processor.AbstractRentingPageProcessor;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.List;

/**
 * 自如房源爬虫程序
 *
 * @author tiancai.zang
 * on 2018-11-29 17:13.
 */
@Slf4j
public class ZiroomPageProcessor extends AbstractRentingPageProcessor {


    public ZiroomPageProcessor(RequirementConf conf) {
        super(conf);
    }

    @Override
    protected List<HouseInfo> processPage(Page page) {

        List<HouseInfo> houseInfos = new ArrayList<>();
        List<Selectable> houseList = page.getHtml().xpath("//*[@id=\"houseList\"]/li").nodes();
        houseList.stream().forEach(house -> {

            log.debug("house : {}", house);

            String name = house.xpath("//div[2]/h3/a/text()").get();
            String url = house.links().get();

            //价格信息暂无法获取
            Double price = 0.0;

            String routeInfo = "";

            houseInfos.add(HouseInfo.builder()
                    .name(name)
                    .url(url)
                    .price(price)
                    .routeInfo(routeInfo)
                    .build());

        });
        return houseInfos;
    }

    @Override
    public Site getSite() {
        return Site.me();
    }
}