package org.laidu.learn.spring.aop.proxy._static;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.spring.aop.service.impl.UserServiceImpl;

/**
 * cglib 代理静态实现(未实现接口)
 * 无法代理 final 方法
 * <p>
 * Created by tiancai.zang
 * on 2018-06-15 16:49.
 *
 * @author tiancai.zang
 */
// TODO: 2018-06-15 16:49  cglib 代理静态实现
@Slf4j
public class StaticCglibProxyDemo extends UserServiceImpl {


    @Override
    public void addUser(String name) {
        log.warn("before add user");
        super.addUser(name);
        log.warn("after add user");
    }

    @Override
    public void removeUser(String name) {
        log.warn("before remove user");
        super.removeUser(name);
        log.warn("after remove user");
    }

    @Override
    public String getUsername(String name) {
        log.warn("before get username");
        String username =  super.getUsername(name);
        log.warn("after get username");

        return username;
    }
}