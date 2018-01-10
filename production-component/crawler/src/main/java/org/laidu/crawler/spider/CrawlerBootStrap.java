package org.laidu.crawler.spider;

import org.laidu.crawler.processor.AbstractPageProcessor;
import org.laidu.crawler.scheduler.RabbitMQScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * spider bootstrap
 *
 * @author tiancai.zang
 * 2018-01-09 16:11.
 */
@Component
public class CrawlerBootStrap extends Spider{

    private final AbstractPageProcessor pageProcessor;
    /**
     * create a spider with pageProcessor.
     *
     * @param pageProcessor pageProcessor
     */
    public CrawlerBootStrap(AbstractPageProcessor pageProcessor, RabbitMQScheduler rabbitMQScheduler) {
        super(pageProcessor);
        this.scheduler = rabbitMQScheduler;
        this.pageProcessor = pageProcessor;
        this.site = pageProcessor.getSite();
    }

    @Bean
    List<CrawlerBootStrap> bootStraps(List<AbstractPageProcessor> pageProcessors, RabbitMQScheduler scheduler){
        List<CrawlerBootStrap> crawlerBootStraps = new ArrayList<>(pageProcessors.size());
        pageProcessors.forEach(pageProcessor -> crawlerBootStraps.add(new CrawlerBootStrap(pageProcessor,scheduler)));
        return crawlerBootStraps;
    }

    @Bean
    Object startCrawler(List<CrawlerBootStrap> bootStraps){
        bootStraps.forEach(bootStrap -> bootStrap.addRequest(pageProcessor.buildRequest()).setExitWhenComplete(false).start());
        return true;
    }
}