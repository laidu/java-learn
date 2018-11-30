package org.laidu.learn.framework.webmagic.renting.processor.ziroom;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.framework.webmagic.renting.conf.RequirementConf;
import org.laidu.learn.framework.webmagic.renting.entity.HouseInfo;
import org.laidu.learn.framework.webmagic.renting.enums.PageTypeEnum;
import org.laidu.learn.framework.webmagic.renting.processor.AbstractRentingPageProcessor;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.Arrays;
import java.util.Collections;
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
    protected List<HouseInfo> processPage(Page page) throws Exception {

        /*
          step 1 : 判断是否为详情页/列表页
         */
        PageTypeEnum pageType = judgePageType(page.getUrl().get());

        switch (pageType) {
            case LIST:

                handleListPage(page);
                break;
            case DETAIL:
                HouseInfo houseInfo = handleDetailPage(page);

                log.debug("houseInfo : {}", houseInfo);

                return Arrays.asList(houseInfo);
            default:
                throw new Exception("未知页面类型");
        }

        return Collections.emptyList();
    }

    private HouseInfo handleDetailPage(Page page) {


        Html html = page.getHtml();

        String name = html.xpath("/html/body/div[3]/div[2]/div[1]/h2/text()").get().trim();

        Selectable detail = html.xpath("/html/body/div[3]/div[2]/ul");

        String areaSize = detail.xpath("/ul//li[1]/text()").get().trim();
        String toward = detail.xpath("/ul//li[2]/text()").get().trim();
        String unit = detail.xpath("/ul//li[3]/text()").get().trim();
        String floor = detail.xpath("/ul//li[4]/text()").get().trim();
        String traffic = detail.xpath("/ul//li[5]/text()").get().trim();

        return HouseInfo.builder()
                .name(name)
                .detail(HouseInfo.HouseDetail.builder()
                        .areaSize(areaSize)
                        .toward(toward)
                        .unit(unit)
                        .floor(floor)
                        .traffic(traffic)
                        .build())
                .build();
    }

    private void handleListPage(Page page) {
        Html pageHtml = page.getHtml();
        Selectable houseList = pageHtml.xpath("//*[@id=\"houseList\"]/li");

        List<String> houseDetialPageUrls = houseList.links()
                .regex("http://www\\.ziroom\\.com/z/vr/[0-9]+\\.html")
                .all();

        page.addTargetRequests(houseDetialPageUrls);

        List<String> listPageUrls = pageHtml.xpath("//*[@id=\"page\"]").links()
                .regex("http://www\\.ziroom\\.com/z/nl/[a-z0-1-]+\\.html\\?p=[0-9]+")
                .all();

        page.addTargetRequests(listPageUrls);
    }


    private PageTypeEnum judgePageType(String url) {
        if (url.contains(".com/z/vr/")) {
            return PageTypeEnum.DETAIL;
        } else if (url.contains("")) {
            return PageTypeEnum.LIST;
        }
        return PageTypeEnum.UNKNOW;
    }

    @Override
    public Site getSite() {
        return Site.me();
    }

    public static void main(String[] args) {

        RequirementConf conf = RequirementConf.builder().build();


        Spider.create(new ZiroomPageProcessor(conf)).addRequest(new Request("http://www.ziroom.com/z/nl/z2-r1.html")).start();
    }
}