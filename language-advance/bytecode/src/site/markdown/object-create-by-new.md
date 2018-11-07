# java 通过new关键字创建新对象

源文件：
```java
package org.laidu.learn.advance.bytecode.jdk;

/**
 * 通过new关键字创建对象
 *
 * @author tiancai.zang
 * on 2018-11-07 10:39.
 */
public class ObjectCreateByNew {

    public static void main(String[] args) {

        Object o = new Object();

        // 使用变量，防止javac编译优化
        System.out.println(o.hashCode());

    }
}
```


```
Classfile /home/laidu/IdeaProjects/java-learn/language-advance/bytecode/target/classes/org/laidu/learn/advance/bytecode/jdk/ObjectCreateByNew.class
  Last modified Nov 7, 2018; size 670 bytes
  MD5 checksum 580a47ca24478027508bd19823b97005
  Compiled from "ObjectCreateByNew.java"
public class org.laidu.learn.advance.bytecode.jdk.ObjectCreateByNew
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #2.#22         // java/lang/Object."<init>":()V
   #2 = Class              #23            // java/lang/Object
   #3 = Fieldref           #24.#25        // java/lang/System.out:Ljava/io/PrintStream;
   #4 = Methodref          #2.#26         // java/lang/Object.hashCode:()I
   #5 = Methodref          #27.#28        // java/io/PrintStream.println:(I)V
   #6 = Class              #29            // org/laidu/learn/advance/bytecode/jdk/ObjectCreateByNew
   #7 = Utf8               <init>
   #8 = Utf8               ()V
   #9 = Utf8               Code
  #10 = Utf8               LineNumberTable
  #11 = Utf8               LocalVariableTable
  #12 = Utf8               this
  #13 = Utf8               Lorg/laidu/learn/advance/bytecode/jdk/ObjectCreateByNew;
  #14 = Utf8               main
  #15 = Utf8               ([Ljava/lang/String;)V
  #16 = Utf8               args
  #17 = Utf8               [Ljava/lang/String;
  #18 = Utf8               o
  #19 = Utf8               Ljava/lang/Object;
  #20 = Utf8               SourceFile
  #21 = Utf8               ObjectCreateByNew.java
  #22 = NameAndType        #7:#8          // "<init>":()V
  #23 = Utf8               java/lang/Object
  #24 = Class              #30            // java/lang/System
  #25 = NameAndType        #31:#32        // out:Ljava/io/PrintStream;
  #26 = NameAndType        #33:#34        // hashCode:()I
  #27 = Class              #35            // java/io/PrintStream
  #28 = NameAndType        #36:#37        // println:(I)V
  #29 = Utf8               org/laidu/learn/advance/bytecode/jdk/ObjectCreateByNew
  #30 = Utf8               java/lang/System
  #31 = Utf8               out
  #32 = Utf8               Ljava/io/PrintStream;
  #33 = Utf8               hashCode
  #34 = Utf8               ()I
  #35 = Utf8               java/io/PrintStream
  #36 = Utf8               println
  #37 = Utf8               (I)V
{
  public org.laidu.learn.advance.bytecode.jdk.ObjectCreateByNew();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 9: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lorg/laidu/learn/advance/bytecode/jdk/ObjectCreateByNew;

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=2, args_size=1
         0: new           #2                  // class java/lang/Object
         3: dup
         4: invokespecial #1                  // Method java/lang/Object."<init>":()V
         7: astore_1
         8: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
        11: aload_1
        12: invokevirtual #4                  // Method java/lang/Object.hashCode:()I
        15: invokevirtual #5                  // Method java/io/PrintStream.println:(I)V
        18: return
      LineNumberTable:
        line 13: 0
        line 16: 8
        line 18: 18
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      19     0  args   [Ljava/lang/String;
            8      11     1     o   Ljava/lang/Object;
}
SourceFile: "ObjectCreateByNew.java"


```