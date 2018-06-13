package org.laidu.learn.language.feature.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

/**
 * list stream demo
 * <p>
 * Created by tiancai.zang
 * on 2018-06-13 11:49.
 *
 * @author tiancai.zang
 */
@Slf4j
public class ListStreamDemo {


    public static String list2String(List<String> list){
        return list.parallelStream().collect(Collectors.joining(","));
    }

    public static String list2String2(List<String> list){
        return String.join(",",list);
    }

}