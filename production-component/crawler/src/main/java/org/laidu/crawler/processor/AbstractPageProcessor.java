package org.laidu.crawler.processor;

import lombok.Getter;
import org.laidu.crawler.entity.ParserResult;
import org.laidu.crawler.enums.WebsiteEnum;
import org.laidu.crawler.model.PageProxy;
import org.laidu.crawler.util.UserAgents;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * abstract page processor
 *
 * @author tiancai.zang
 * 2018-01-09 16:14.
 */
public abstract class AbstractPageProcessor implements PageProcessor {

    @Getter
    private final Site site;
    @Getter
    private final WebsiteEnum websiteEnum;

    AbstractPageProcessor() {
        this.site = buildSite();
        this.websiteEnum = getWebsiteEnum();
    }

    /**
     * get website enum
     * @return website enum
     */
    public abstract WebsiteEnum getWebsiteEnum();

    /**
     * request build
     * @return build request
     */
    public abstract Request buildRequest();

    public abstract ParserResult parser(PageProxy page);

    @Override
    public void process(Page page) {
        ParserResult parserResult = parser(new PageProxy(page));
        parserResult.getResults().forEach(result -> page.getResultItems().put(websiteEnum.getCode(),result));
        parserResult.getRequests().forEach(page::addTargetRequest);
    }

    /**
     * build site
     * @return site
     */
    protected Site buildSite() {
        return Site.me()
                .setCharset("UTF-8")
                .setUserAgent(getUserAgent());
    }

    /**
     * default get random userAgent
     * @return random userAgent
     */
    protected String getUserAgent(){
        return UserAgents.getRandomUserAgent();
    }

    /**
     * use proxy
     * @return use proxy
     */
    protected boolean useProxy(){
        return false;
    }
}