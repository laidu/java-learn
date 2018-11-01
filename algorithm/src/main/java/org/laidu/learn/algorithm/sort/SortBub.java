package org.laidu.learn.algorithm.sort;

import static org.laidu.learn.algorithm.sort.SortUtil.print;
import static org.laidu.learn.algorithm.sort.SortUtil.swap;


/**
 * 冒泡排序
 * <p>
 * Created by tiancai.zang
 * on 2018-10-31 22:54.
 */
public class SortBub {


    public static void main(String[] args) {

        int[] sort = new SortBub().sort(new int[]{12, 32, 1, 3, 4, 5, 7, 2});

        print(sort);
    }

    public int[] sort(int[] a){

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a.length-1; j++) {
                if (a[j] > a[j+1]) {
                    swap(a,j,j+1);
                }
            }
        }

        return a;
        
    }


}