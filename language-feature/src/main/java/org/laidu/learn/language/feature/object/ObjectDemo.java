package org.laidu.learn.language.feature.object;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Object 方法测试
 *
 * @author tiancai.zang
 * on 2018-11-05 17:45.
 */
public class ObjectDemo {

    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException, IllegalAccessException, InstantiationException, InvocationTargetException, IOException {

        // 通过new关键字创建新对象
        RawObject o1 = new RawObject();

        // 使用clone方式创建指定对象副本，前提是该对象必须实现Cloneable接口
        RawObject o2 = (RawObject) o1.clone();

        // 使用反射方法中的newInstance调用无参构造器, 前提是该对象必须提供了无参构造器
        RawObject o3 = o2.getClass().newInstance();

        // 使用反射获取构造器，通过指定构造器创建新对象, 该类必须实现序列化接口
        for (Constructor<?> constructor : o3.getClass().getConstructors()) {
            Object o = constructor.newInstance(null);
        }

        // 通过序列化创建新对象
        String fileName = System.getProperty("user.dir")+"/language-feature/src/main/resources/rawObject.bin";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(fileName)))) {
            out.writeObject(o2);
        }
        RawObject o4 = null;
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(fileName)))) {
            o4 = (RawObject) in.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        assert o4 != null;
        System.out.println(o4.hashCode());

        System.out.println(o1.hashCode());
        System.out.println(o2.hashCode());


    }


    /**
     * 当class未指定任何父类时，默认继承于Object
     *
     */
    public static class RawObject implements Cloneable,Serializable{
        private static final long serialVersionUID = 1L;

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}