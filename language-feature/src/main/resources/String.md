# java String 处理

## 1、相关类

类名 | 描述
--- | ---
java.lang.String | String类表示字符串，Java程序中的所有字符串文字（例如“abc”）都被实现为此类的实例。<br/>字符串不变;它们的值在创建后不能被更改。<br/>字符串缓冲区支持可变字符串。因为String对象是不可变的，它们可以被共享。
java.lang.StringBuilder | 一个可变的字符序列。 该类提供与StringBuffer兼容的API，但不能保证同步。 <br/>这个类被设计为在字符串缓冲区被单个线程使用的地方（作为通常的情况）用作StringBuffer的插入替换。 <br/>在可能的情况下，建议使用此类优先于StringBuffer，因为它在大多数实现中将更快。
java.lang.StringBuffer | 线程安全，可变的字符序列。 字符串缓冲区就像一个String，但可以修改。 <br/>在任何时间点，它包含一些特定的字符序列，但可以通过某些方法调用来更改序列的长度和内容。


## 2、对比



## 3、String

>String 类代表字符串。Java 程序中的所有字符串字面值（如 "abc" ）都作为此类的实例实现。

>字符串是常量；它们的值在创建之后不能更改。字符串缓冲区支持可变的字符串。因为 String 对象是不可变的，所以可以共享。例如：

     String str = "abc";
 
>等效于：

     char data[] = {'a', 'b', 'c'};
     String str = new String(data);
 
>下面给出了一些如何使用字符串的更多示例：

     System.out.println("abc");
     String cde = "cde";
     System.out.println("abc" + cde);
     String c = "abc".substring(2,3);
     String d = cde.substring(1, 2);
 
>String 类包括的方法可用于检查序列的单个字符、比较字符串、搜索字符串、提取子字符串、创建字符串副本并将所有字符全部转换为大写或小写。
大小写映射基于 Character 类指定的 Unicode 标准版。

>Java 语言提供对字符串串联符号（"+"）以及将其他对象转换为字符串的特殊支持。
字符串串联是通过 StringBuilder（或 StringBuffer）类及其 append 方法实现的。
字符串转换是通过 toString 方法实现的，该方法由 Object 类定义，并可被 Java 中的所有类继承。
有关字符串串联和转换的更多信息，请参阅 Gosling、Joy 和 Steele 合著的 The Java Language Specification。

>除非另行说明，否则将 null 参数传递给此类中的构造方法或方法将抛出 NullPointerException。

>String 表示一个 UTF-16 格式的字符串，其中的增补字符 由代理项对 表示（有关详细信息，请参阅 Character 类中的 Unicode 字符表示形式）。
索引值是指 char 代码单元，因此增补字符在 String 中占用两个位置。

>String 类提供处理 Unicode 代码点（即字符）和 Unicode 代码单元（即 char 值）的方法

### 3.1 String 常用方法


## 4、StringBuilder

>一个可变的字符序列。 该类提供与StringBuffer兼容的API，但不能保证同步。 
这个类被设计为在字符串缓冲区被单个线程使用的地方（作为通常的情况）用作StringBuffer的插入替换。 
在可能的情况下，建议优先于StringBuffer使用此类，因为它在大多数实现中更快。

>在 StringBuilder 上的主要操作是 append 和 insert 方法，可重载这些方法，以接受任意类型的数据。
每个方法都能有效地将给定的数据转换成字符串，然后将该字符串的字符追加或插入到字符串生成器中。
append 方法始终将这些字符添加到生成器的末端；而 insert 方法则在指定的点添加字符。

>例如，如果 z 引用一个当前内容为 "start" 的字符串的生成器对象，
则该方法调用 z.append("le") 将使字符串生成器包含 "startle"，
而 z.insert(4, "le") 将更改字符串生成器，使之包含 "starlet"。

>通常，如果 sb 引用 StringBuilder 的实例，则 sb.append(x) 和 sb.insert(sb.length(), x) 具有相同的效果。
每个字符串生成器都有一定的容量。只要字符串生成器所包含的字符序列的长度没有超出此容量，就无需分配新的内部缓冲区。
如果内部缓冲区溢出，则此容量自动增大。
将 StringBuilder 的实例用于多个线程是不安全的。如果需要这样的同步，则建议使用 StringBuffer。


## 5、StringBuffer

>线程安全的可变字符序列。一个类似于 String 的字符串缓冲区，但不能修改。
虽然在任意时间点上它都包含某种特定的字符序列，但通过某些方法调用可以改变该序列的长度和内容。
 
>可将字符串缓冲区安全地用于多个线程。
可以在必要时对这些方法进行同步，因此任意特定实例上的所有操作就好像是以串行顺序发生的，该顺序与所涉及的每个线程进行的方法调用顺序一致。

>StringBuffer 上的主要操作是 append 和 insert 方法，可重载这些方法，以接受任意类型的数据。
每个方法都能有效地将给定的数据转换成字符串，然后将该字符串的字符追加或插入到字符串缓冲区中。
append 方法始终将这些字符添加到缓冲区的末端；而 insert 方法则在指定的点添加字符。
 
>例如，如果 z 引用一个当前内容为 "start" 的字符串缓冲区对象，
则此方法调用 z.append("le") 会使字符串缓冲区包含 "startle"，
而 z.insert(4, "le") 将更改字符串缓冲区，使之包含 "starlet"。
 
>通常，如果 sb 引用 StringBuilder 的一个实例，则 sb.append(x) 和 sb.insert(sb.length(), x) 具有相同的效果。
 
>当发生与源序列有关的操作（如源序列中的追加或插入操作）时，该类只在执行此操作的字符串缓冲区上而不是在源上实现同步。
 
>每个字符串缓冲区都有一定的容量。
只要字符串缓冲区所包含的字符序列的长度没有超出此容量，就无需分配新的内部缓冲区数组。
如果内部缓冲区溢出，则此容量自动增大。
从 JDK 5 开始，为该类补充了一个单个线程使用的等价类，即 StringBuilder。
与该类相比，通常应该优先使用 StringBuilder 类，因为它支持所有相同的操作，但由于它不执行同步，所以速度更快。



