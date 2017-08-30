package org.laidu.learn.design.pattern.chain.responsibility;

import lombok.extern.slf4j.Slf4j;

/**
 * 客户端
 * User: zangtiancai
 * Date: 2017/8/30
 * Time: 下午4:04
 */
@Slf4j
public class Client {

    private static AbstractLogger getChainOfLoggers(){

        AbstractLogger errorLogger = new ConcreteLoggerInfo();
        AbstractLogger fileLogger = new ConcreteLoggerDebug();
        AbstractLogger consoleLogger = new ConcreteLoggerError();

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {

        AbstractLogger loggerChain = getChainOfLoggers();

        log.info("-*--*--*--*- INFO -*--*--*--*--");
        loggerChain.logMessage(AbstractLogger.INFO,
                "This is an information.");

        log.info("-*--*--*--*- DEBUG -*--*--*--*--");
        loggerChain.logMessage(AbstractLogger.DEBUG,
                "This is an debug level information.");

        log.info("-*--*--*--*- ERROR -*--*--*--*--");
        loggerChain.logMessage(AbstractLogger.ERROR,
                "This is an error information.");
    }
}
