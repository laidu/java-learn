# 迭代器模式(Iterator Pattern)

## 1 定义
> Provide a way to access the elements of an aggregate object sequentially whitout exposing its underlying representation.

> 提供一种方法访问容器对象中的各个元素，而又不需要暴露该方法的内部细节。目前已经是一种没落的模式，基本上没人会单独写一个迭代器。
    
## 2 角色
* Iterator 抽象迭代器
* Concrete Iterator 具体迭代器
* Aggregate 抽象容器
* Concrete Aggregate 具体容器

## 3 类图
![](image/iterator.png)

## 4 优点
* 性能优良 
> 原型模式是在内存二进制流的拷贝，要比直接new一个对象性能好很多，特别是要在一个循环体重产生大量的对象时，原型模式可用更好地体现其优点。
* 逃避构造函数的约束
> 这既是它的优点也是缺点，直接在内存中拷贝，构造函数是不会执行的。优点是减少了约束，缺点也是减少了约束，需要在实际应用时考虑。

## 5 缺点

## 6 注意
* 会绕过构造器
* 遇到final字段会报错

## 7 应用
* 资源初始化场景
* 性能和安全要求的场景
* 一个对象的多个修改者的场景

    在实际应用中原型模式经常和工厂模式配合使用，通过clone方法创建一个对象，然后由工厂方法提供给调用者。