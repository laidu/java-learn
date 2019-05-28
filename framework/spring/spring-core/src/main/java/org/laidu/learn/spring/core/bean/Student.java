package org.laidu.learn.spring.core.bean;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * student bean
 * <p>
 * Created by zangtiancai.
 * on 2019-02-13 19:29.
 */
@Slf4j(topic = "student")
@Data
@ToString
public class Student {

    private String name;

    private String idCard;

    public void setName(String name) {
        log.info("===========setName===========: {}",name);
        this.name = name;
    }

    public void setIdCard(String idCard) {
        log.info("===========setIdCard===========: {}",idCard);
        this.idCard = idCard;
    }

    public Student() {
        log.info("===========无参构造器===========");
    }

    public Student(String name, String idCard) {
        this.name = name;
        this.idCard = idCard;
       log.info("===========全参构造器===========");

    }

    public Student(String name) {
        this.name = name;
        log.info("===========name参构造器===========");
    }

    public void init(){
        log.info("===========init方法===========");
    }

}
