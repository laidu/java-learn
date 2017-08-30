# 责任链模式

## 1 介绍

### 1.1 模式动机

> 避免请求发送者与接收者耦合在一起，让多个对象都有可能接收请求，
将这些对象连接成一条链，并且沿着这条链传递请求，直到有对象处理它为止。

### 1.2 模式定义

> 责任链模式（Chain of Responsibility Pattern）为请求创建了一个接收者对象的链。
这种模式给予请求的类型，对请求的发送者和接收者进行解耦。这种类型的设计模式属于行为型模式。

### 1.3 适用环境

> * 1、有多个对象可以处理同一个请求，具体哪个对象处理该请求由运行时刻自动确定。 
> * 2、在不明确指定接收者的情况下，向多个对象中的一个提交一个请求。 
> * 3、可动态指定一组对象处理请求。

### 1.4 模式应用

> * 1、红楼梦中的"击鼓传花"。 
> * 2、JS 中的事件冒泡。 
> * 3、JAVA WEB 中 Apache Tomcat 对 Encoding 的处理，Struts2 的拦截器，jsp servlet 的 Filter。

### 1.5 优点

> * 1、降低耦合度。它将请求的发送者和接收者解耦。 
> * 2、简化了对象。使得对象不需要知道链的结构。 
> * 3、增强给对象指派职责的灵活性。通过改变链内的成员或者调动它们的次序，允许动态地新增或者删除责任。 
> * 4、增加新的请求处理类很方便。

### 1.6 缺点

> * 1、不能保证请求一定被接收。 
> * 2、系统性能将受到一定影响，而且在进行代码调试时不太方便，可能会造成循环调用。 
> * 3、可能不容易观察运行时的特征，有碍于除错。

### 1.7 模式结构

> 责任链模式包含如下角色：

* > AbstractHandler: 抽象处理者角色 定义出一个处理请求的接口。
如果需要，接口可以定义 出一个方法以设定和返回对下家的引用。
这个角色通常由一个Java抽象类或者Java接口实现。
* > ConcreteHandler: 具体处理者角色 具体处理者接到请求后，可以选择将请求处理掉，或者将请求传给下家。
由于具体处理者持有对下家的引用，因此，如果需要，具体处理者可以访问下家。

![](image/chain-responsibility.png)

### 1.8 时序图

## 2 代码分析

> AbstractLogger:

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

> ConcreteLoggerDebug:
    
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
    
> ConcreteLoggerError: 

    @Slf4j
    public class ConcreteLoggerError extends AbstractLogger {
    
        public ConcreteLoggerError() {
            super(ERROR);
        }
        @Override
        protected void write(String message) {
            log.error("-*--*--*--*- {} -*--*--*--*--",message);
        }
    }
    
> ConcreteLoggerInfo: 

    @Slf4j
    public class ConcreteLoggerInfo extends AbstractLogger {
    
        public ConcreteLoggerInfo() {
            super(INFO);
        }
        @Override
        protected void write(String message) {
            log.info("-*--*--*--*- {} -*--*--*--*--",message);
        }
    }

> Client :

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

## 3 模式分析

## 4 实例

## 模式扩展

## 总结

> 责任链模式其实就是一个灵活版的if…else…语句，它就是将这些判定条件的语句放到了各个处理类中，
这样做的优点是比较灵活了，但同样也带来了风险，比如设置处理类前后关系时，
一定要特别仔细，搞对处理类前后逻辑的条件判断关系，并且注意不要在链中出现循环引用的问题。