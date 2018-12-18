package org.laidu.learn.tool.spring.stopwatch;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.tool.spring.stopwatch.source.StopWatch;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tiancai.zang
 * on 2018-11-21 23:02.
 */
@Slf4j
public class HashMapDemo {

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            test();
        }

    }

    private static void test() {

        Object o = new Object();
        Map<Integer,Object> map1 = new HashMap<>(100000);
        Map<Integer,Object> map2 = new HashMap<>(10000000);

        StopWatch s1 = new StopWatch();
        StopWatch s2 = new StopWatch();
        s1.start();
        Long temp = 0L;
        for (int i = 0; i < 100_000_000; i++) {
//            map1.put(i,o);
            temp++;
        }
        s1.stop();
        System.out.println(map1.size());

        System.out.println(temp);
        temp=0L;
        s2.start();
        for (int i = 0; i < 1_000_000_000; i++) {
//            map2.put(i,o);
            temp++;

        }
        s2.stop();
        System.out.println(temp);
        System.out.println(map2.size());

        System.out.println(String.format("s1 : %s , s2 %s  :",s1.getTotalTimeMillis(),s2.getTotalTimeMillis())+s2.getTotalTimeMillis()*1.0/s1.getTotalTimeMillis());
    }

}