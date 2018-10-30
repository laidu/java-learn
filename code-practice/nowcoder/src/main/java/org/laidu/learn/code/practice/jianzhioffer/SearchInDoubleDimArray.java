package org.laidu.learn.code.practice.jianzhioffer;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * 二维数组中的查找 (杨氏矩阵)
 * <p>
 *  题目描述
 *  在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *  请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * Created by tiancai.zang
 * on 2018-03-04 17:25.
 * @author laidu
 */
@Slf4j
public class SearchInDoubleDimArray {

    /**
     * 通过二分法查找
     * @param target
     * @param array
     * @return
     */
    public static boolean findByBinarySearch(int target, int [][] array) {
        if (array.length <= 0){
            return false;
        }
        if (array[0].length <= 0){
            return false;
        }

        int rowSize = array.length;
        int rankSize = array[0].length;

        if (target < array[0][0] || target > array[rowSize-1][rankSize-1]){
            return false;
        }
        AtomicBoolean result = new AtomicBoolean(false);
        Arrays.stream(array).forEach(row -> {
            if (Arrays.binarySearch(row,target) >= 0){
                result.set(true);
            }
        });
        return result.get();

    }

    /**
     * 转换 list
     * @param target
     * @param array
     * @return
     */
    public static boolean convertListQuery(int target, int [][] array) {

        List<Integer> list = Arrays.stream(array)
                .flatMap(var -> Arrays.stream(var).boxed())
                .distinct()
                .collect(Collectors.toList());


        return list.contains(target);

    }

    public static void main(String[] args) {


        int[][] ayyays = {{1, 2, 3}, {2, 33, 2}};

        int target = 2;

        boolean b = convertListQuery(target,ayyays);

        System.out.println(b);
    }

}