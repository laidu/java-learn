package org.laidu.learn.design.pattern.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * 代理主题角色
 * User: zangtiancai
 * Date: 2017/8/30
 * Time: 上午11:28
 */
@Slf4j
public class ProxySubject extends AbstractSubject {

    private ConcreteSubject subject;

    ProxySubject() {
        this.subject = new ConcreteSubject();
    }

    @Override
    public void request(String name) {

        preRequest(name); // 请求前置处理

        subject.request(name);

        postRequest(name); // 请求后置处理

    }

    private void preRequest(String name) {
        log.info("-*--*--*--*- pre request : {} -*--*--*--*--",name);
    }

    private void postRequest(String name) {
        log.info("-*--*--*--*- post request : {} -*--*--*--*--",name);
    }
}
