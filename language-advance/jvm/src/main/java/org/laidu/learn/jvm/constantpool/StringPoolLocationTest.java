package org.laidu.learn.jvm.constantpool;

/**
 * 字符串池存放位置 测试
 * -Xms8m -Xmx8m -Xmn4 -XX:MaxMetaspaceSize=10m
 * <p>
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 * 	at java.base/jdk.internal.misc.Unsafe.allocateUninitializedArray0(Unsafe.java:1276)
 * 	at java.base/jdk.internal.misc.Unsafe.allocateUninitializedArray(Unsafe.java:1269)
 * 	at java.base/java.lang.invoke.StringConcatFactory$MethodHandleInlineCopyStrategy.newArray(StringConcatFactory.java:1633)
 * 	at java.base/java.lang.invoke.DirectMethodHandle$Holder.invokeStatic(DirectMethodHandle$Holder)
 * 	at java.base/java.lang.invoke.LambdaForm$MH/0x00000001000aa840.invoke(LambdaForm$MH)
 * 	at java.base/java.lang.invoke.Invokers$Holder.linkToTargetMethod(Invokers$Holder)
 * 	at org.laidu.learn.jvm.constantpool.StringPoolLocationTest.main(StringPoolLocationTest.java:18)
 * Created by tiancai.zang
 * on 2018-11-08 23:49.
 */
public class StringPoolLocationTest {

    public static void main(String[] args) {

        for (int i = 0; i < 999999; i++) {

            String var = ("的教案设计大师就会看到哈三等奖"+i).intern();
            for (int j = 0; j < 99999; j++) {

                var += (var + j * 100).intern();

                System.out.println(var);
            }
        }

    }
}