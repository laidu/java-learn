package org.laidu.learn.algorithm.sort;

import static org.laidu.learn.algorithm.sort.SortUtil.print;


/**
 * 选择排序
 * <p>
 * Created by tiancai.zang
 * on 2018-10-31 22:54.
 */
public class SortSel {


    public static void main(String[] args) {

        int[] sort = new SortSel().sort(new int[]{12, 32, 1, 3, 4, 5, 7, 2});

        print(sort);
    }

    public int[] sort(int[] a){

        for (int i = 0; i < a.length; i++) {

            int min = a[i];

            for (int j = i; j < a.length; j++) {
                if (min > a[j]) {

                    min = a[j];
                    SortUtil.swap(a,i,j);
                }
            }
        }

        return a;
        
    }


}