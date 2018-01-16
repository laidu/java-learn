package org.laidu.crawler.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.laidu.crawler.config.RabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.scheduler.DuplicateRemovedScheduler;
import us.codecraft.webmagic.scheduler.MonitorableScheduler;

/**
 * rabbitmq based scheduler
 *
 * @author tiancai.zang
 * 2018-01-09 14:27.
 */
@Slf4j
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component()
public class RabbitMQScheduler extends DuplicateRemovedScheduler implements MonitorableScheduler {

    private final RabbitAdmin admin;
    private final AmqpTemplate amqpTemplate;
    private final RabbitConfig config;

    @Autowired
    public RabbitMQScheduler(AmqpTemplate amqpTemplate, RabbitConfig config, RabbitAdmin admin) {
        this.amqpTemplate = amqpTemplate;
        this.config = config;
        this.admin = admin;
    }

    @Override
    public Request poll(Task task) {

        Request request = null;
        try {
            request = (Request)amqpTemplate.receiveAndConvert(config.getQueueName());
        }catch (Exception e){
            log.error("poll request error",e);
        }

        return request;
    }

    @Override
    protected void pushWhenNoDuplicate(Request request, Task task) {
        try {
            amqpTemplate.convertAndSend(config.getExchangeName(),config.getRouteKey(),request);
        }catch (Exception e){
            log.error("push request error", e);
        }
    }

    @Override
    public int getLeftRequestsCount(Task task) {
        return getDuplicateRemover().getTotalRequestsCount(task);
    }

    @Override
    public int getTotalRequestsCount(Task task) {
        return Integer.parseInt(admin.getQueueProperties(config.getQueueName()).getProperty(String.valueOf(RabbitAdmin.QUEUE_CONSUMER_COUNT)));
    }
}