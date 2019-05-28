package org.laidu.learn.spring.core.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 父亲
 *
 * @author zangtiancai.
 * @date 2019-05-27 19:53.
 */
@Component
public class Father extends Person{

    @Autowired
    private Child child;

    public Father() {
    }

    public Father(String name) {
        super(name);
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }
}
