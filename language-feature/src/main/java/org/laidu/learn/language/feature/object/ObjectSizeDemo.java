package org.laidu.learn.language.feature.object;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * 对象在内存中的大小
 *
 * @author zangtiancai
 * @date 2019-03-18 18:58.
 */
@Slf4j
public class ObjectSizeDemo {

    public static void main(String[] args) throws IOException, InterruptedException {

        log.info("new Object() size: {}",InstrumentationAgent.getObjectSize(new Object()));
        log.info("new Integer.MAX_VALUE size: {}",InstrumentationAgent.getObjectSize(Integer.MAX_VALUE));
        log.info("1 size: {}",InstrumentationAgent.getObjectSize(1));
        log.info("1L size: {}",InstrumentationAgent.getObjectSize(1L));
        log.info("'1' size: {}",InstrumentationAgent.getObjectSize('1'));

        log.info("new String() size: {}",InstrumentationAgent.getObjectSize(new String()));
        log.info("hello size: {}",InstrumentationAgent.getObjectSize("hello"));
        log.info("hello world size: {}",InstrumentationAgent.getObjectSize("hello world,hahhahahh"));
        log.info("new String() size: {}",InstrumentationAgent.getObjectSize(new String()));

        int[] a = new int[]{0,1,2,3,4,5,6,7};
        log.info("new int[] size: {}",InstrumentationAgent.getObjectSize(a));

        List<Integer> list = new ArrayList<>(1024);
        log.info("new ArrayList<>() size: {}",InstrumentationAgent.getObjectSize(list));

        list.add(0);
        log.info("new ArrayList<>() size: {}",InstrumentationAgent.getObjectSize(list));

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        log.info("new ArrayList<>() size: {}",InstrumentationAgent.getObjectSize(list));

    }

}
