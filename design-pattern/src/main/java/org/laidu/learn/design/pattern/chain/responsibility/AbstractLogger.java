package org.laidu.learn.design.pattern.chain.responsibility;

import lombok.Getter;
import lombok.Setter;

/**
 * 抽象处理角色
 * User: zangtiancai
 * Date: 2017/8/30
 * Time: 下午3:47
 */
public abstract class AbstractLogger {

    public final static int INFO = 1;
    public final static int DEBUG = 2;
    public final static int ERROR = 3;

    protected int level;

    public AbstractLogger(int level) {
        this.level = level;
    }

    public AbstractLogger(int level, AbstractLogger nextLogger) {
        this.level = level;
        this.nextLogger = nextLogger;
    }

    @Setter
    @Getter
    //责任链中的下一个元素
    private AbstractLogger nextLogger;

    public void logMessage(int level, String message) {
        if (this.level == level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);
}
