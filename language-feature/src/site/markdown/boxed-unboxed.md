# java 基础类型 自动拆装箱源码 学习

> 拆箱、装箱操作属于java的语法糖之一。在Java SE5之前，如果要生成一个数值为10的Integer对象，必须这样进行：
    
    Integer i = new Integer(10);
> 而在从Java SE5开始就提供了自动装箱的特性，如果要生成一个数值为10的Integer对象，只需要这样就可以了：
  
    Integer i = 10;
    
> 简单一点说，装箱就是  自动将基本数据类型转换为包装器类型；拆箱就是  自动将包装器类型转换为基本数据类型。
 
    Integer i = 10;  //装箱
    int n = i;   //拆箱

## 1 java 中基础类型

> java 中包含4种8类基础类型，分别为4种整型、2种浮点型、boolean、char

基本类型 | 占用空间(Byte) | 标识范围 | 包装器类型
---|---|---|---
boolean | 1/8 | true/false | Boolean
char | 2 | -128~127 | Character
byte | 1 | -128~127 | Byte
short | 2 | -2ˆ15~2ˆ15-1 | Short
int | 4 | -2ˆ31~2ˆ31-1 | Integer
long | 8 | -2ˆ63~2ˆ63-1 | Long
float | 4 | -3.403E38~3.403E38 | Float
double | 8 | -1.798E308~1.798E308 | Double

> 通过分析 java.lang.Integer 源码来理解 java基础类型的拆装箱。
Integer类在对象中包装一个原始类型int的值。类型为Integer的对象包含一个类型为int的单个字段。
此外，该类还提供了几种将int转换为String和String到int的方法，以及处理int时使用的其他常量和方法

## 2 自动类型转换
> 整型、实型（常量）、字符型数据可以混合运算。运算中，不同类型的数据先转化为同一类型，然后进行运算。
 转换从低级到高级。

    低  ------------------------------------>  高

    byte,short,char—> int —> long—> float —> double

## 3 源码分析

> 这里我们通过反编译源码分析自动拆装箱过程：

> 源代码：
    
    public static void main(String[] args) {
    
            Integer i = 10;         // 装箱
            int n = i;          //拆箱
    }
        
> 反编译class文件：

    public static void main(String[] args) {
            Integer i = Integer.valueOf(10);
            int n = i.intValue();
    }
    
> 接下来着重看一下 Integer.valueOf 、 i.intValue()方法：

### 3.1 Integer.valueOf 方法：

    public static Integer valueOf(int i) {
            if (i >= IntegerCache.low && i <= IntegerCache.high)
                return IntegerCache.cache[i + (-IntegerCache.low)];
            return new Integer(i);
    }
    
> 其中 IntegerCache.cache方法实现为：

    private static class IntegerCache {
        static final int low = -128;
        static final int high;
        static final Integer cache[];

        static {
            // high value may be configured by property
            int h = 127;
            String integerCacheHighPropValue =
                sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
            if (integerCacheHighPropValue != null) {
                try {
                    int i = parseInt(integerCacheHighPropValue);
                    i = Math.max(i, 127);
                    // Maximum array size is Integer.MAX_VALUE
                    h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
                } catch( NumberFormatException nfe) {
                    // If the property cannot be parsed into an int, ignore it.
                }
            }
            high = h;

            cache = new Integer[(high - low) + 1];
            int j = low;
            for(int k = 0; k < cache.length; k++)
                cache[k] = new Integer(j++);

            // range [-128, 127] must be interned (JLS7 5.1.7)
            assert IntegerCache.high >= 127;
        }

        private IntegerCache() {}
    }

> 从这两段代码可以看出，在通过valueOf方法创建Integer对象的时候，如果数值在\[-128,127\]之间，
便返回指向IntegerCache.cache中已经存在的对象的引用；否则创建一个新的Integer对象。

### 3.1 Integer.xxxValue 方法：

    public int intValue() {
            return value;
    }

