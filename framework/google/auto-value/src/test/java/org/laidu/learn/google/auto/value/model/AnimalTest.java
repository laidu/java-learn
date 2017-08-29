package org.laidu.learn.google.auto.value.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ${DESCRIPTION}
 * User: zangtiancai
 * Date: 2017/8/29
 * Time: 下午3:04
 */
class AnimalTest {
    @Test
    void create() {

        Animal animal = Animal.builder().build();

        System.out.println(animal);
    }

}