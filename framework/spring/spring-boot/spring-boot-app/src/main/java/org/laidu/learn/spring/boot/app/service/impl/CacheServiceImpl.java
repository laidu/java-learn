package org.laidu.learn.spring.boot.app.service.impl;

import org.laidu.learn.spring.boot.app.service.CacheService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements CacheService {

    @Override
    @Cacheable(cacheNames = {"aa"}, key = "'aa' + #id")
    public String aaName(Long id) {
        return "asdsa";
    }

    @Override
    @Cacheable(cacheNames = {"aa"}, key = "'aa2' + #id")
    public String aaName2(Long id) {
        return "asdsa";
    }

    /**
     * 只会清除相同cachenames下的缓存
     * @param id
     * @return
     */
    @Override
    @CacheEvict(cacheNames = {"aa"}, allEntries = true)
    public String aaClear(Long id) {
        return null;
    }

    @Override
    @Cacheable(cacheNames = {"bb"}, key = "'bb' + #id")
    public String bbName(Long id) {
        return null;
    }

    @Override
    @Cacheable(cacheNames = {"bb"}, key = "'bb2' + #id")
    public String bbName2(Long id) {
        return null;
    }

    @Override
    @CacheEvict(cacheNames = {"bb"}, allEntries = true)
    public String bbClear(Long id) {
        return null;
    }
}
