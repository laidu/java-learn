package org.laidu.learn.spring.aop.proxy.cglib;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.spring.aop.service.UserService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * cglib proxy demo
 * <p>
 * Created by tiancai.zang
 * on 2018-06-15 16:31.
 * @Link org.springframework.aop.framework.CglibAopProxy#getProxy(java.lang.ClassLoader)
 * @author tiancai.zang
 */
@Slf4j
@AllArgsConstructor
public class CglibProxyDemo {

    private UserService userService;

    public UserService getUserService(){

        // 声明增加类实例
        Enhancer en = new Enhancer();
        // 设置被代理类字节码，CGLIB根据字节码生成被代理类的子类
        en.setSuperclass(userService.getClass());
        // 设置回调函数，即一个方法拦截
        en.setCallback((MethodInterceptor) (arg0, method, args, arg3) -> {
            // 注意参数object,仍然为外部声明的源对象，且Method为JDK的Method反射
            log.info("pre class: {} method: {} return type:{} args:{}", userService.getClass().getName(),method.getName(),method.getReturnType(),args);
            Object result = method.invoke(userService, args);
            log.info("post class: {} method: {} return type:{} result:{}", userService.getClass().getName(),method.getName(),method.getReturnType(),result);
            return result;
        });
        return (UserService) en.create();
    }
}