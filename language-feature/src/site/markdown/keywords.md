# java 语法 关键字
   [oracle/javase/tutorial/java/nutsandbolts/_keywords](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html)

## summary(50个)

|  |  |  |  |  |
| --- | --- | --- | --- | --- |
abstract | continue | for | new | switch
assert\*** | default | goto* | package | synchronized
boolean | do | if | private | this
break | double | implements | protected | throw
byte | else | import | public | throws
case | enum\**** | instanceof | return | transient
catch | extends | int | short | try
char | final | interface | static | void
class | finally | long | strictfp\** | volatile
const\* | float | native | super | while
|  |  |  |  |  |


\*	 	not used
\**	 	added in 1.2
\***	 	added in 1.4
\****	 	added in 5.0



## category

* 访问控制

    关键字 | 说明
    | :--- | :--- | 
    private | 私有的
    protected | 受保护的
    public | 公共的

* 类、方法和变量修饰符
    
    关键字 | 说明
    | :--- | :--- | 
    abstract | 声明抽象
    interface | 声明接口
    class | 声明类
    extends | 继承
    final | 不可改变
    implements | 实现
    native | 原声方法（非java实现）
    new | 新,创建
    static | 静态
    [strictfp](strictfp.md) | 严格,精准, 用于浮点运算更加精确；一旦使用了关键字strictfp来声明某个类、接口或者方法时，那么在这个关键字所声明的范围内所有浮点运算都是精确的，符合IEEE-754规范的
    [synchronized](synchronized.md) | 线程,同步
    [transient](transient.md) | 只能修饰变量，被transient关键字修饰的变量不再能被 __Serializable接口__ 序列化，一个静态变量不管是否被transient修饰，均不能被序列化。
    [volatile](volatile.md) | 禁止指令重排序、保证变量可见性
    
* 程序控制语句
    
    关键字 | 说明
    | :--- | :--- | 
     break | 跳出循环
     case | 定义一个值以供switch选择
     continue | 继续
     default | 默认
     do | 运行
     else | 否则
     for | 循环
     if | 如果
     [instanceof](instanceof.md) | 用来在运行时指出对象是否是特定类的一个实例
     return | 返回
     switch | 根据值选择执行
     while | 循环
* 错误处理
    
    关键字 | 说明
    | :--- | :--- | 
    assert | 断言表达式是否为真
    catch | 捕捉异常
    finally | 有没有异常都执行
    throw | 抛出一个异常对象
    throws | 声明一个异常可能被抛出
    try | 捕获异常
* 包相关
    
    关键字 | 说明
    | :--- | :--- | 
    import | 引入
    package | 包
* 基本类型
    
    关键字 | 说明
    | :--- | :--- | 
    boolean | 布尔型
    byte | 字节型
    char | 字符型
    double | 双精度浮点
    float | 单精度浮点
    int | 整型
    long | 长整型
    short | 短整型
    null | 空
* 变量引用
    
    关键字 | 说明
    | :--- | :--- | 
    [super](super.md) | 父类普通的直接引用、子类中的成员变量或方法与父类中的成员变量或方法同名、引用构造函数
    [this](this.md) | 普通的直接引用、形参与成员名字重名，用this来区分、引用构造函数
    void | 无返回值
* 保留关键字
    
    关键字 | 说明
    | :--- | :--- | 
    goto | 是关键字，但不能使用
    const | 是关键字，但不能使用