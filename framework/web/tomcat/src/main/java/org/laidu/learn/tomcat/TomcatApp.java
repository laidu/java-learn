package org.laidu.learn.tomcat;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * tomcat embed app
 *
 *
 * @author zangtiancai
 * @date 2019-02-15 14:34.
 */
@Slf4j
public class TomcatApp {

    public static void main(String[] args) throws LifecycleException {

        // TODO: 完成hello搭建. create by zangtiancai on 2019-02-15 19:39.
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        tomcat.addServlet("","",new HelloServlet());

        tomcat.start();
        tomcat.getServer().await();

    }

    public static class HelloServlet extends GenericServlet{

        @Override
        public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
            log.info(" local name {}",req.getLocalName());
        }
    }
}
