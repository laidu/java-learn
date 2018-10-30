package org.laidu.learn.code.practice.jianzhioffer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

class SearchInDoubleDimArrayTest {

    private List<int[][]> inputs = new ArrayList<>();

    /**
     * 一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     */
    @BeforeEach
    void setUp() {

        int [][] a = new int[10][10];
        IntStream.range(0,10).forEach( var -> {
            int start = 100-10*(var+1);
            IntStream.range(0, 10).forEach(value -> {
                a[var][value] = start + 10*(value+1);
            });
        });

        inputs.add(a);

        for (int i = 9; i >= 0 ; i--){
            for (int j = 0; j<10 ; j++){
                System.out.print(a[j][i]+" ");
            }
            System.out.println();
        }
    }

    @Test
    void find() {

        Random random = new Random();
        inputs.forEach(array -> {
            int randomInt = random.nextInt(40)*10;
            boolean reault = SearchInDoubleDimArray.findByBinarySearch(randomInt,array);
            System.out.println(randomInt + " result " + reault);
        });
    }
}