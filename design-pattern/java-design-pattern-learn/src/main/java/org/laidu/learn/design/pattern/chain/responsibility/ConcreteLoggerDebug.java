package org.laidu.learn.design.pattern.chain.responsibility;

import lombok.extern.slf4j.Slf4j;

/**
 * 具体处理者角色
 * User: zangtiancai
 * Date: 2017/8/30
 * Time: 下午3:49
 */
@Slf4j
public class ConcreteLoggerDebug extends AbstractLogger {

    public ConcreteLoggerDebug() {
        super(DEBUG);
    }
    @Override
    protected void write(String message) {
        log.debug("-*--*--*--*- {} -*--*--*--*--",message);
    }
}
