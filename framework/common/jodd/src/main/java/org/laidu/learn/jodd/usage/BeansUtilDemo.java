package org.laidu.learn.jodd.usage;

import jodd.bean.BeanCopy;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

/**
 * beantutil
 *
 * @author tiancai.zang
 * on 2018-08-28 11:50.
 */
// TODO: 2018-08-28 11:50  beantutil
@Slf4j
public class BeansUtilDemo {

    public static void main(String[] args) {

        Person a = Person.builder()
                .name("a")
                .male(1)
                .age(12)
                .build();

        Person b = Person.builder().build();
        BeanCopy.beans(a,b).copy();

        Student student1 = Student.studengBuilder().build();
        BeanCopy.beans(a,student1).copy();

        Animal animal = Animal.builder().build();
        BeanCopy.beans(a,animal).copy();


        School school1 = School.builder()
                .name("aaa")
                .students(Collections.singletonList(student1))
                .build();

        School school2 = School.builder().build();

        BeanCopy.beans(school2,school1).copy();

        System.out.println(b);
    }

    @Data
    @Builder
    static class Person{
        String name;
        Integer male;
        Integer age;
    }


    @Data
    @Builder
    static class Animal{
        String name1;
        Integer male11;
        Integer age;
    }

    @Data
    static class Student extends Person{

        @Builder(builderMethodName = "studengBuilder")
        public Student(String name, Integer male, Integer age, Integer score) {
            super(name, male, age);
            this.score = score;
        }

        Integer score;
    }

    @Data
    @Builder
    static class School{

        private String name;
        List<Student> students;
    }
}