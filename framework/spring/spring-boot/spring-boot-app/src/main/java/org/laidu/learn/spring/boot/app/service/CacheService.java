package org.laidu.learn.spring.boot.app.service;

/**
 * 缓存service
 */
public interface CacheService {

    String aaName(Long id);

    String aaName2(Long id);

    String aaClear(Long id);

    String bbName(Long id);

    String bbName2(Long id);

    String bbClear(Long id);

}
