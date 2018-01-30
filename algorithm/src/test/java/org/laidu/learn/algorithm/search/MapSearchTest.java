package org.laidu.learn.algorithm.search;

import lombok.extern.slf4j.Slf4j;
import org.laidu.commom.util.encryption.MD5Util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * map search
 *
 * @author tiancai.zang
 * 2018-01-30 17:43.
 */
@Slf4j // TODO: 2018-01-30 17:43  map search
public class MapSearchTest {

    public static void main(String[] args) {

        Map<String,Long> phoneMap = new HashMap<>(50000000);

        long num = 130000000;
        for (long i=0; i< 5000_0000;i++ ){
            phoneMap.put(MD5Util.getInstance().toMd5(String.valueOf(num+i)).substring(0,16),num+i);
            if (i%100000==0){
                log.info("i 's value : {}", i);
                log.info("phoneMap.size() 's value : {}", phoneMap.size());
            }
        }

        log.info("phoneMap.size() 's value : {}", phoneMap.size());

        Long start = System.currentTimeMillis();
        for (long i=0; i< 100;i++ ){
            Random random = new Random();
            phoneMap.get(MD5Util.getInstance().toMd5(String.valueOf(num+ random.nextInt(50000000))).substring(0,16));
        }
        log.info("System.currentTimeMillis()-start 's value : {}", System.currentTimeMillis()-start);


    }
}