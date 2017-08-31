# mockito 使用教程

[参考 mockito 2.9.0 JavaDoc](http://static.javadoc.io/org.mockito/mockito-core/2.9.0/index.html?org/mockito/Mockito.html)

> Mockito是mocking框架，它让你用简洁的API做测试。而且Mockito简单易学，它可读性强和验证语法简洁。

## 1 mockito相关介绍

### 1.1 为什么需要Mock

> 测试驱动的开发( TDD)要求我们先写单元测试，再写实现代码。
在写单元测试的过程中，我们往往会遇到要测试的类有很多依赖，
这些依赖的类/对象/资源又有别的依赖，从而形成一个大的依赖树，
要在单元测试的环境中完整地构建这样的依赖，是一件很困难的事情。

### 1.2 Stub和Mock异同

> * 相同：Stub和Mock都是模拟外部依赖。
> * 不同：Stub是完全模拟一个外部依赖，而Mock还可以用来判断测试通过还是失败。

## 2 使用mockito

> 添加Maven依赖

    <dependency>
       <groupId>org.mockito</groupId>
       <artifactId>mockito-core</artifactId>
       <version>2.9.0</version>
       <scope>test</scope>
    </dependency>

> 添加Junit依赖

    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
    </dependency>
    
> 添加引用

    import static org.mockito.Mockito.*;
    import static org.junit.Assert.*;


## 3 常用的测试方法

### 3.1 验证某些行为

      // 静态导入会使代码更简洁
      import static org.mockito.Mockito.*;
     
      // mock creation 创建mock对象
      List mockedList = mock(List.class);
     
      //using mock object 使用mock对象
      mockedList.add("one");
      mockedList.clear();
     
      //verification 验证
      verify(mockedList).add("one");
      verify(mockedList).clear();

> 一旦mock对象被创建了，mock对象会记住所有的交互。然后你就可能选择性的验证你感兴趣的交互。

### 3.2 如何做一些测试桩 (Stub)

     //You can mock concrete classes, not only interfaces
     // 你可以mock具体的类型,不仅只是接口
     LinkedList mockedList = mock(LinkedList.class);
    
     //stubbing
     // 测试桩
     when(mockedList.get(0)).thenReturn("first");
     when(mockedList.get(1)).thenThrow(new RuntimeException());
    
     //following prints "first"
     // 输出“first”
     System.out.println(mockedList.get(0));
    
     //following throws runtime exception
     // 抛出异常
     System.out.println(mockedList.get(1));
    
     //following prints "null" because get(999) was not stubbed
     // 因为get(999) 没有打桩，因此输出null
     System.out.println(mockedList.get(999));
    
     //Although it is possible to verify a stubbed invocation, usually it's just redundant
     //If your code cares what get(0) returns then something else breaks (often before even verify() gets executed).
     //If your code doesn't care what get(0) returns then it should not be stubbed. Not convinced? See here.
     // 验证get(0)被调用的次数
     verify(mockedList).get(0);

> * 默认情况下，所有的函数都有返回值。mock函数默认返回的是null，一个空的集合或者一个被对象类型包装的内置类型，例如0、false对应的对象类型为Integer、Boolean；
> * 测试桩函数可以被覆写 : 例如常见的测试桩函数可以用于初始化夹具，但是测试函数能够覆写它。请注意，覆写测试桩函数是一种可能存在潜在问题的做法；
> * 一旦测试桩函数被调用，该函数将会一致返回固定的值；
> * 上一次调用测试桩函数有时候极为重要-当你调用一个函数很多次时，最后一次调用可能是你所感兴趣的。

### 3.3 参数匹配器 (matchers)

Mockito以自然的java风格来验证参数值: 使用equals()函数。有时，当需要额外的灵活性时你可能需要使用参数匹配器，也就是argument matchers :

     //stubbing using built-in anyInt() argument matcher
     // 使用内置的anyInt()参数匹配器
     when(mockedList.get(anyInt())).thenReturn("element");
    
     //stubbing using custom matcher (let's say isValid() returns your own matcher implementation):
     // 使用自定义的参数匹配器( 在isValid()函数中返回你自己的匹配器实现 )
     when(mockedList.contains(argThat(isValid()))).thenReturn("element");
    
     //following prints "element"
     // 输出element
     System.out.println(mockedList.get(999));
    
     //you can also verify using an argument matcher
     // 你也可以验证参数匹配器
     verify(mockedList).get(anyInt());

> 参数匹配器的注意点 : 

> 如果你使用参数匹配器,所有参数都必须由匹配器提供。

> 示例 : ( 该示例展示了如何多次应用于测试桩函数的验证 ) 

    verify(mock).someMethod(anyInt(), anyString(), eq("third argument"));
    //above is correct - eq() is also an argument matcher
    // 上述代码是正确的,因为eq()也是一个参数匹配器
    
    verify(mock).someMethod(anyInt(), anyString(), "third argument");
    //above is incorrect - exception will be thrown because third argument 
    // 上述代码是错误的,因为所有参数必须由匹配器提供，而参数"third argument"并非由参数匹配器提供，因此的缘故会抛出异常

> 像anyObject(), eq()这样的匹配器函数不会返回匹配器。它们会在内部将匹配器记录到一个栈当中，并且返回一个假的值，通常为null。`这样的实现是由于被Java编译器强加的静态类型安全`。结果就是你不能在验证或者测试桩函数之外使用anyObject(), eq()函数。


## 4 mockito在Spring中的应用