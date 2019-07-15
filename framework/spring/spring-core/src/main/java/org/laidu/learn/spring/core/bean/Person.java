package org.laidu.learn.spring.core.bean;

/**
 * 人类
 *
 * @author zangtiancai.
 * @date 2019-05-27 19:55.
 */
public class Person {

    private String name;


    public Person() {
        System.out.println(" 无参构造器实例化 :"+ this.getClass().getName());
    }

    public Person(String name) {
        System.out.println(" 含参构造器实例化bean ： "+ name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("set person name " + name);
        this.name = name;
    }
}
