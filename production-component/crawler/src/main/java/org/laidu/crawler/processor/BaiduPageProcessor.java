package org.laidu.crawler.processor;

import lombok.extern.slf4j.Slf4j;
import org.laidu.crawler.entity.ParserResult;
import org.laidu.crawler.enums.WebsiteEnum;
import org.laidu.crawler.model.PageProxy;
import org.laidu.crawler.request.RequestBuilder;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import java.util.Date;

/**
 * baidu page processor
 *
 * @author tiancai.zang
 * 2018-01-10 10:22.
 */
@Slf4j
@Component
public class BaiduPageProcessor extends AbstractPageProcessor{

    @Override
    public WebsiteEnum getWebsiteEnum() {
        return WebsiteEnum.BAIDU;
    }

    @Override
    protected Site buildSite() {
        return super.buildSite();
    }

    @Override
    public Request buildRequest() {
        return RequestBuilder.get("https://www.baidu.com/");
    }

    @Override
    public ParserResult parser(PageProxy page) {
        ParserResult result = ParserResult.builder().build();
        result.addResult(ParserResult.Result.<Date>builder().data(new Date()).build());
        for (int i=0;i<10;i++){
            result.addRequest(RequestBuilder.get("https://www.baidu.com?t="+System.currentTimeMillis()+i));
        }
        return result;
    }

}