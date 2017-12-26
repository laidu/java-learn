package org.laidu.learn.design.pattern.prototype;

/**
 * client
 * <p>
 *
 * @author tiancai.zang
 * @date 2017-12-25 14-31
 */
public class Client {

    public static void main(String[] args) {

        Person person1 = new Person("xiaoming",1,"java developer");

        Person person2 = (Person) person1.clone();

        person2.setJob("python developer");

        System.out.println(person2);

    }
}