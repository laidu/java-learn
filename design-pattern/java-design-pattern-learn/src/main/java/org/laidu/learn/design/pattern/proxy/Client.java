package org.laidu.learn.design.pattern.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * 测试
 * User: zangtiancai
 * Date: 2017/8/30
 * Time: 上午11:36
 */
@Slf4j
public class Client {

    private final static ProxySubject proxy = new ProxySubject();

    public static void main(String[] args) {

        proxy.request("nihao");

    }
}
