package org.laidu.learn.spring.core.beanfactory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * 通过xml 初始化容器
 * <p>
 * Created by zangtiancai.
 * on 2019-02-13 19:28.
 */
@Slf4j
public class XmlCreateIOC {

    public static void main(String[] args) throws InterruptedException {

        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("xml/spring.xml"));

//        Student student = factory.getBean(Student.class);

        System.out.println(factory);

    }
}
