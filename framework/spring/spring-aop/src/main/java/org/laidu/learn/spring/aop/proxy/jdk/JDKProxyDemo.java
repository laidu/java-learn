package org.laidu.learn.spring.aop.proxy.jdk;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.spring.aop.service.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk proxy demo
 * <p>
 * Created by tiancai.zang
 * on 2018-06-15 16:30.
 *
 * @author tiancai.zang
 */
@Slf4j
@AllArgsConstructor
public class JDKProxyDemo {

    private UserService userService;

    public  UserService getUserService(){

        ProxyHandler proxyHandler = new ProxyHandler(userService);
        return (UserService) Proxy.newProxyInstance(proxyHandler.getClass().getClassLoader(),userService.getClass().getInterfaces(),proxyHandler);
    }

    @AllArgsConstructor
    private static class ProxyHandler implements InvocationHandler{

        private UserService userService;

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            log.warn("before {} call", method.getName());

            Object result = method.invoke(userService,args);

            log.warn("after {} call", method.getName());

            return result;
        }
    }
}