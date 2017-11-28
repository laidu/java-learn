package org.laidu.learn.algorithm.dijkstra;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
class DoubleStackArithmeticExpressionTest {

    private DoubleStackArithmeticExpression doubleStackArithmeticExpression;

    @BeforeEach
    void setUp() {
        doubleStackArithmeticExpression = new DoubleStackArithmeticExpression();
    }

    @Test
    void calculate() {

        String expression = "(2+(2*4))";
        int expected = 10;

        int result = doubleStackArithmeticExpression.calculate(expression);

        Assert.assertEquals(expected,result);

    }

}