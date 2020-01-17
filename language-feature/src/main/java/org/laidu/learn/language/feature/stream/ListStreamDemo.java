package org.laidu.learn.language.feature.stream;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

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


    /**
     * 流实现 list<String> 转 String
     * @param list
     * @return
     */
    public static String list2String(List<String> list){
        return list.parallelStream().collect(Collectors.joining(","));
    }

    /**
     * 使用 String.join 实现 List<String> 转 String
     * @param list
     * @return
     */
    public static String list2String2(List<String> list){
        return String.join(",",list);
    }


    /**
     * list 根据字段去重
     * @param students
     * @return
     */
    public static List<Student> distinctBy(List<Student> students) {

        if (students == null || students.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        return students.stream()
                .distinct()
                .collect(Collectors.toList());
    }


    @Data
    public static class Student {

        private Long num;

        private String name;

        private String grade;

        private Integer score;
    }

}