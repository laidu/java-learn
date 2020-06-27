package org.laidu.learn.algorithm.leetcode;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FirstMissingPositiveTest {

    private FirstMissingPositive firstMissingPositive;

    @BeforeEach
    public void setUp() {
        firstMissingPositive = new FirstMissingPositive();
    }

    @Test
    void test1() {
        Assert.assertEquals(3, firstMissingPositive.firstMissingPositive(new int[]{1,2,0}));
        Assert.assertEquals(2, firstMissingPositive.firstMissingPositive(new int[]{3,4,-1,1}));
        Assert.assertEquals(1, firstMissingPositive.firstMissingPositive(new int[]{7,8,9,11,12}));

    }

    @Test
    void firstMissingPositive2() {
        Assert.assertEquals(3, firstMissingPositive.firstMissingPositive2(new int[]{1,2,0}));
        Assert.assertEquals(2, firstMissingPositive.firstMissingPositive2(new int[]{3,4,-1,1}));
        Assert.assertEquals(1, firstMissingPositive.firstMissingPositive2(new int[]{7,8,9,11,12}));

    }
}