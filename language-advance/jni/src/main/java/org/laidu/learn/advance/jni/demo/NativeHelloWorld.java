package org.laidu.learn.advance.jni.demo;

/**
 * 使用native 方法实现 helloworld
 *
 * gcc -I/usr/lib/jvm/java-11-jdk/include -I/usr/lib/jvm/java-11-jdk/include/linux org_laidu_learn_advance_jni_demo_NativeHelloWorld.c  -shared -z noexecstack  -o NativeHelloWorld.so
 * @author tiancai.zang
 * on 2018-11-19 11:17.
 */
public class NativeHelloWorld {

    static {
        System.load(System.getProperty("user.dir")+"/language-advance/jni/src/main/resources/lib/NativeHelloWorld.so");
    }


    public native void hello();

    public static void main(String[] args) {

        new NativeHelloWorld().hello();
    }
}