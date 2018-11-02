package org.laidu.learn.advance.bytecode.cglib;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 工人 代理
 *
 * @author tiancai.zang
 * on 2018-11-01 16:27.
 */
@Slf4j
public class WorkerProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println(" 上班 ");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println(" 下班 ");
        return result;
    }
}