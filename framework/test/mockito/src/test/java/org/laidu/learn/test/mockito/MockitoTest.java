package org.laidu.learn.test.mockito;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

@Slf4j
@DisplayName("Mockito 方法测试")
class MockitoTest {

    /**
     * 一旦mock对象被创建了，mock对象会记住所有的交互。然后你就可能选择性的验证你感兴趣的交互。
     */
    @Test
    @DisplayName("验证某些行为")
    void verifyBehaviour() {

        // mock creation 创建mock对象
        List mockedList = mock(List.class);

        //using mock object 使用mock对象
        mockedList.add("one");
        mockedList.get(1);
        mockedList.clear();

        //verification 验证
        verify(mockedList).clear();
        verify(mockedList).add("one");
        verify(mockedList).get(1);
    }

    /**
     * 默认情况下，所有的函数都有返回值。mock函数默认返回的是null，一个空的集合或者一个被对象类型包装的内置类型，例如0、false对应的对象类型为Integer、Boolean；
     * 测试桩函数可以被覆写 : 例如常见的测试桩函数可以用于初始化夹具，但是测试函数能够覆写它。请注意，覆写测试桩函数是一种可能存在潜在问题的做法；
     * 一旦测试桩函数被调用，该函数将会一致返回固定的值；
     * 上一次调用测试桩函数有时候极为重要-当你调用一个函数很多次时，最后一次调用可能是你所感兴趣的。
     */
    @Test
    @DisplayName("测试桩 (Stub)")
    void stubbing() {

        //You can mock concrete classes, not just interfaces
        LinkedList mockedList = mock(LinkedList.class);

        //stubbing
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        //following prints "first"
        System.out.println(mockedList.get(0));

        //following throws runtime exception
        System.out.println(mockedList.get(1));

        //following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));

        //Although it is possible to verify a stubbed invocation, usually it's just redundant
        //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
        //If your code doesn't care what get(0) returns, then it should not be stubbed. Not convinced? See here.
        verify(mockedList).get(0);
    }

    /**
     * Methods inherited from class org.mockito.ArgumentMatchers
     * any, any, anyBoolean, anyByte, anyChar, anyCollection, anyCollectionOf, anyDouble, anyFloat,
     * anyInt, anyIterable, anyIterableOf, anyList, anyListOf, anyLong, anyMap, anyMapOf, anyObject,
     * anySet, anySetOf, anyShort, anyString, anyVararg, argThat, booleanThat, byteThat, charThat,
     * contains, doubleThat, endsWith, eq, eq, eq, eq, eq, eq, eq, eq, eq, floatThat, intThat, isA,
     * isNotNull, isNotNull, isNull, isNull, longThat, matches, matches, notNull, notNull, nullable,
     * refEq, same, shortThat, startsWith
     */
    @Test
    @DisplayName("参数匹配器")
    void paramMatcher(){

        //You can mock concrete classes, not just interfaces
        LinkedList mockedList = mock(LinkedList.class);

        //stubbing
//        when(mockedList.get(1)).thenThrow(new RuntimeException());
        when(mockedList.get(anyInt())).thenReturn("first");

        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(1));

    }

    /**
     * verify函数默认验证的是执行了times(1)，也就是某个测试函数是否执行了1次.因此，times(1)通常被省略了。
     */
    @Test
    @DisplayName("验证函数被调用的次数")
    void verifyMethodCallTimes(){

        // mock creation 创建mock对象
        List mockedList = mock(List.class);

        //using mock
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        // 下面的两个验证函数效果一样,因为verify默认验证的就是times(1)
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        // 验证具体的执行次数
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        // 使用never()进行验证,never相当于times(0)
        verify(mockedList, never()).add("never happened");

        // 使用atLeast()/atMost()
        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(0)).add("five times");
        verify(mockedList, atMost(10)).add("three times");
    }



}