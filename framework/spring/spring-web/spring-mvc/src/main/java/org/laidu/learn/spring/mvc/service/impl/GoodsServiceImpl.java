package org.laidu.learn.spring.mvc.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.laidu.learn.spring.mvc.model.Goods;
import org.laidu.learn.spring.mvc.service.GoodsService;
import org.springframework.stereotype.Service;

/**
 * @author tiancai.zang
 * on 2018-08-23 11:54.
 */
@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {

    @Override
    public Long addGoods(Goods goods) {

        System.out.println("add goods: "+ goods);

        return RandomUtils.nextLong();
    }
}