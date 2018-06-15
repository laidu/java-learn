package org.laidu.learn.spring.aop.service;

/**
 * user service
 * <p>
 * Created by tiancai.zang
 * on 2018-06-15 16:32.
 */
public interface UserService {

    /**
     * @param name
     */
    void addUser(String name);

    /**
     * @param name
     */
    void removeUser(String name);

    /**
     * @param name
     * @return
     */
    String getUsername(String name);

    String getUsernameFromSelf(String name);

}
