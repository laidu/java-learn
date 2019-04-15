package org.laidu.learn.spring.data.redis.service;

import org.laidu.learn.spring.data.redis.model.UserInfo;

/**
 * user service
 * <p>
 * Created by tiancai.zang
 * on 2018-05-23 14:28.
 * @author laidu
 */
public interface UserService {

    /**
     * get user info by userId.
     * @param id
     * @return
     */
    UserInfo getUserInfo(String id);

    /**
     * add user.
     * @param username
     * @param password
     * @return
     */
    UserInfo addUser(String username, String password);

    /**
     * modify username.
     *
     */
    UserInfo updateUsername(String id, String username);
}
