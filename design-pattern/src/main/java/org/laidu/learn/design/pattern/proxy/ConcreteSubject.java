package org.laidu.learn.design.pattern.proxy;

import lombok.Data;

/**
 * 真实主题角色
 * User: zangtiancai
 * Date: 2017/8/30
 * Time: 上午11:29
 */
@Data
public class ConcreteSubject extends AbstractSubject{

    public void request(String name){
        System.out.println(String.format("request %s ",name));
    }
}
