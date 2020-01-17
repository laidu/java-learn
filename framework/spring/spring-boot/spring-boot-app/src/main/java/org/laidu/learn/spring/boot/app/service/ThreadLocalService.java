package org.laidu.learn.spring.boot.app.service;

/**
 * 包含threadLocal对象，重现内存泄漏问题
 *
 * @author zangtiancai.
 * @date 2019/12/23 下午9:28.
 */
public interface ThreadLocalService {

    String sayHello(String reqBody);
}
