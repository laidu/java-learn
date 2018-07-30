
package org.laidu.learn.spring.cloud.consumer.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import jodd.util.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.spring.cloud.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/**
 * hello service
 * <p>
 * Created by laidu
 * on 2018-07-23 16:55.
 *
 * @author laidu
 */
@Slf4j
@Service
public class HelloServerImpl implements HelloService {


    private final RestTemplate restTemplate;

    @Autowired
    public HelloServerImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @HystrixCommand(fallbackMethod = "helloErrorFallBack",commandKey = "helloKey")
    public String hello() {

        ThreadUtil.sleep(new Random().nextInt(300));

        return restTemplate.getForEntity("http://hello-service/hello",String.class).getBody();
    }

    public String helloErrorFallBack(){
        return "error";
    }
}