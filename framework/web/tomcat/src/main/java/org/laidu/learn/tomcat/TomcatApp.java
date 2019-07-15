package org.laidu.learn.tomcat;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import lombok.extern.slf4j.Slf4j;

/**
 * tomcat embed app
 * 嵌入式tomcat 示例
 *
 * @author zangtiancai
 * @date 2019-02-15 14:34.
 */
@Slf4j
public class TomcatApp {

    public static void main(String[] args) throws LifecycleException {

        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8080);
        tomcat.setBaseDir(".temp/");

        String contentPath = "/hello";

        Context ctx = tomcat.addContext(contentPath, new File(".").getAbsolutePath());

        tomcat.addServlet(contentPath, "helloServlet", new HelloServlet());
        ctx.addServletMappingDecoded("/*", "helloServlet");

        // tomcat embed 9.0.x 以后的版本如需使用默认connector需要显示调用该方法，
        // 或者设置自定义connector
        // 参考https://bz.apache.org/bugzilla/show_bug.cgi?id=60297
        tomcat.getConnector();

        tomcat.start();
        tomcat.getServer().await();

    }

    @WebServlet(asyncSupported = true)
    public static class HelloServlet extends HttpServlet {

        @Override
        public void service(ServletRequest req, ServletResponse res) throws IOException {
            PrintWriter writer = res.getWriter();

            res.setContentType("application/json;charset=utf-8");
            res.setCharacterEncoding("utf-8");

            String jsonBody = String.format("{\"code\":200,\"message\":\"hello world\",\"timestamp\":%d}",
                    System.currentTimeMillis());

            writer.write(jsonBody);
            writer.flush();
            writer.close();
        }
    }
}
