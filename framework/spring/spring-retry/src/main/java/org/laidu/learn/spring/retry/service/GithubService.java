package org.laidu.learn.spring.retry.service;

import org.laidu.learn.spring.retry.model.GithubUserInfo;

/**
 * github service
 * <p>
 * Created by tiancai.zang
 * on 2019-02-20 23:28.
 */
public interface GithubService {

    /**
     * 获取github 用户公开信息
     * @param user
     * @return
     */
    GithubUserInfo queryUserInfo(String user);
}
