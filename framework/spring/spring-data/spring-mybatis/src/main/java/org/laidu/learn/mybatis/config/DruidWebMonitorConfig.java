//package org.laidu.learn.mybatis.config;
//
//import java.io.IOException;
//import java.util.Map;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
//import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;
//import com.alibaba.druid.support.http.StatViewServlet;
//import com.alibaba.druid.support.http.WebStatFilter;
//import com.alibaba.druid.util.Utils;
//import com.google.common.collect.Maps;
//
//import lombok.extern.slf4j.Slf4j;
//
///**
// * durid config
// * <p>
// * Created by tiancai.zang
// * on 2018-04-22 16:22.
// * @author laidu
// */
//@Slf4j
//@Configuration
//@ConditionalOnWebApplication
//@AutoConfigureAfter(DruidDataSourceAutoConfigure.class)
//@ConditionalOnProperty(name = "spring.datasource.druid.stat-view-servlet.enabled", havingValue = "true",
//        matchIfMissing = false)
//public class DruidWebMonitorConfig {
//
//    @Bean
//    public ServletRegistrationBean druidServlet() {
//        log.info("init Druid Servlet Configuration ");
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
//        servletRegistrationBean.setServlet(new StatViewServlet());
//        servletRegistrationBean.addUrlMappings("/druid/*");
//        Map<String, String> initParameters = Maps.newHashMap();
//        initParameters.put("loginUsername", "admin");
//        initParameters.put("loginPassword", "admin");
//        // 禁用HTML页面上的“Reset All”功能
//        initParameters.put("resetEnable", "false");
//        // IP白名单 (没有配置或者为空，则允许所有访问)
//        initParameters.put("allow", "");
//        //initParameters.put("deny", "192.168.20.38");// IP黑名单 (存在共同时，deny优先于allow)
//        servletRegistrationBean.setInitParameters(initParameters);
//        return servletRegistrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new WebStatFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        return filterRegistrationBean;
//    }
//
//
//    @Bean
//    public FilterRegistrationBean fuckDruidAdFilterRegistrationBean(DruidStatProperties properties) {
//        // 获取web监控页面的参数
//        DruidStatProperties.StatViewServlet config = properties.getStatViewServlet();
//        // 提取common.js的配置路径
//        String pattern = config.getUrlPattern() != null ? config.getUrlPattern() : "/druid/*";
//        String commonJsPattern = pattern.replaceAll("\\*", "js/common.js");
//
//        final String filePath = "js/common.js";
//
//        Filter filter = new Filter() {
//            @Override
//            public void init(FilterConfig filterConfig) throws ServletException {
//            }
//
//            @Override
//            public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//                chain.doFilter(request, response);
//                // 重置缓冲区，响应头不会被重置
//                response.resetBuffer();
//                // 获取common.js
//                String text = Utils.readFromResource(filePath);
//                // 正则替换banner
//                text = text.replaceAll("<a.*?banner\"></a><br/>", "");
//                response.getWriter().write(text);
//            }
//
//            @Override
//            public void destroy() {
//            }
//        };
//
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.setFilter(filter);
//        registrationBean.addUrlPatterns(commonJsPattern);
//        return registrationBean;
//    }
//
//}