package org.laidu.learn.language.feature.object;

/**
 * Object 方法测试
 *
 * @author tiancai.zang
 * on 2018-11-05 17:45.
 */
public class ObjectDemo {

    public static void main(String[] args) throws InterruptedException {

        Object o1 = new Object();
        Object o2 = new Object(){
            @Override
            public Object clone() throws CloneNotSupportedException {
                return super.clone();
            }
        };


        System.out.println(o1.hashCode());
        System.out.println(o2.hashCode());


    }
}