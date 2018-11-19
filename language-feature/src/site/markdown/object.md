# Object 深入解析

##1、 简介
> 类 Object 是类层次结构的根类。每个类都使用 Object 作为超类。所有对象（包括数组）都实现这个类的方法。(未继承任何超类的类将自动继承Object)

##2、类图

![](image/Object.png)

##3、方法预览(API)

方法签名 | 描述
--- | ---
protected native Object clone() | 创建并返回此对象的一个副本。
public boolean equals(Object obj) | 指示其他某个对象是否与此对象“相等”。
protected void finalize() | 当垃圾回收器确定不存在对该对象的更多引用时，由对象的垃圾回收器调用此方法。
public final native Class<?> getClass() | 返回此 Object 的运行时类。
public native int hashCode() | 返回该对象的哈希码值。
public final native void notify() | 唤醒在此对象监视器上等待的单个线程。
public final native void notifyAll() | 唤醒在此对象监视器上等待的所有线程。
private static native void registerNatives() | 其主要作用是将C/C++中的方法映射到Java中的native方法，实现方法命名的解耦。
public String toString() | 返回该对象的字符串表示。
public final void wait() | 在其他线程调用此对象的 notify() 方法或 notifyAll() 方法前，导致当前线程等待。
public final void wait(long timeout) | 在其他线程调用此对象的 notify() 方法或 notifyAll() 方法，或者超过指定的时间量前，导致当前线程等待。
public final void wait(long timeout, int nanos) | 在其他线程调用此对象的 notify() 方法或 notifyAll() 方法，或者其他某个线程中断当前线程，或者已超过某个实际时间量前，导致当前线程等待。

##4、常用方法解析

### 4.1、clone

> 创建并返回此对象的一个副本。

java 源码：
```java
protected native Object clone() throws CloneNotSupportedException;
```
[c源码](http://hg.openjdk.java.net/jdk8u/jdk8u60/jdk/file/37a05a11f281/src/share/native/java/lang/Object.c)：
```c++
```
#### 4.1.1 java创建对象的几种方式

方式 | 描述 | 原理
---|---|---
new 关键字 | 调用构造器 | 调用构造器
反射 | 通过反射调用newInstance或者调用指定Constructor创建对象 | 通过调用构造器
clone | 通过clone获取对象副本 | 通过native clone方法
序列化 | 通过序列化创建新实例 | 通过序列化

```
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
```

#### 4.1.2 深克隆与浅克隆
> * 浅克隆 只克隆当前对象和引用对象的引用 
> * 深克隆 克隆当前对象及其应用对象

### 4.2、hashCode & equals

java 源码：
```java
public native int hashCode();
```
[c源码](http://hg.openjdk.java.net/jdk8u/jdk8u60/jdk/file/37a05a11f281/src/share/native/java/lang/Object.c)：
```c++
```
#### 4.2.1、hash算法

#### 4.2.2、hashCode方法的应用
#### 4.2.3、equals方法的应用
#### 4.2.4、默认的hashCode生成策略
#### 4.2.5、对比

### 4.3、wait & notify

### 4.4、getClass


参考： 
* [java se 6 api](http://tool.oschina.net/apidocs/apidoc?api=jdk-zh)
* [java-se 11 Object](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Object.html)
