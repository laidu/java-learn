package org.laidu.learn.framework.webmagic.renting.processor;

import org.laidu.learn.framework.webmagic.renting.conf.RequirementConf;
import org.laidu.learn.framework.webmagic.renting.entity.HouseInfo;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * 房源信息爬虫抽象类
 *
 * @author tiancai.zang
 * on 2018-11-29 17:14.
 */
public abstract class AbstractRentingPageProcessor implements PageProcessor {

    private final RequirementConf conf;

    public AbstractRentingPageProcessor(RequirementConf conf) {
        this.conf = conf;
    }

    /**
     * 爬虫处理逻辑
     * @param page
     */
    @Override
    public void process(Page page) {


        List<HouseInfo> houseInfos = null;
        try {
            houseInfos = processPage(page);
        } catch (Exception e) {
            e.printStackTrace();
        }

        houseInfos.stream()
                .filter(this::filter)
                .forEach(houseInfo -> page.getResultItems().put(houseInfo.getName(),houseInfo));
    }

    /**
     * 房源信息筛选
     * @param houseInfo
     * @return
     */
    protected Boolean filter(HouseInfo houseInfo){
        return houseInfo.getPrice() < this.conf.getHighPrice() && queryExpireElapsed(houseInfo.getName(), this.conf.getDestination()) < this.conf.getExpireElapsed();
    }

    /**
     * @param source 出发地
     * @param dest 目的地
     * @return 获取房源信息到目的所消耗的最短时间(分钟)
     */
    protected int queryExpireElapsed(String source,String dest){
        int elapsed = -1;

        return elapsed;
    }

    /**
     * 页面解析逻辑
     * @param page
     * @return
     */
    protected abstract List<HouseInfo> processPage(Page page) throws Exception;

}