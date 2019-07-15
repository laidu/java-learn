package org.laidu.learn.spring.core.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 孩子
 *
 * @author zangtiancai.
 * @date 2019-05-27 19:54.
 */
@Component
public class Child extends Person{

    @Autowired
    private Father father;

    public Child() {
    }

    public Child(String name) {
        super(name);
    }


    public Father getFather() {
        return father;
    }

    public void setFather(Father father) {

        System.out.println("set father");
        this.father = father;
    }
}
