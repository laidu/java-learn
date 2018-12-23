package org.laidu.learn.language.feature.net.http;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * http server demo
 *
 * @author tiancai.zang
 * on 2018-11-06 17:17.
 */
@Slf4j
public class HttpServerDemo {

    public static void main(String[] args) {

    }

    @WebServlet("/")
    public static class DemoServlet extends GenericServlet{

        private static final long serialVersionUID = 6747504141486704337L;

        @Override
        public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
            res.getWriter().write("helle");
        }
    }
}