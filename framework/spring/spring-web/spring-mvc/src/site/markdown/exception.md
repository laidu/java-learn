# Spring MVC 异常处理


注意：
使用 @ControllerAdvice 处理异常也有一定的 局限性。只有进入 Controller 层的错误，才会由 @ControllerAdvice 处理。拦截器 抛出的错误，以及 访问错误地址 的情况 @ControllerAdvice 处理不了，由 Spring Boot 默认的 异常处理机制 处理。

参考：

[]()
[]()
[Spring Boot中Web应用的统一异常处理](http://blog.didispace.com/springbootexception/)
[]()