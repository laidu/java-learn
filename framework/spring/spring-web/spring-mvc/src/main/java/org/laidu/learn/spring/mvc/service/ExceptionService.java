package org.laidu.learn.spring.mvc.service;

/**
 * 模拟service异常
 *
 * @author zangtiancai
 * @date 2019-03-21 21:04.
 */
public interface ExceptionService {

    /**
     * 模拟exception
     * @return
     */
    String exception();

    /**
     * 模拟null exception
     * @return
     */
    String nullException();
}
