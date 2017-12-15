package org.laidu.learn.amqp.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.amqp.service.Calculate;
import org.springframework.stereotype.Service;
/**
 * calculate
 * <p>
 * Created by tiancai.zang on 2017-11-28 15:26.
 */
@Slf4j
@Service
public class CalculateImpl implements Calculate{


    @Override
    public int calculate(int n) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
}