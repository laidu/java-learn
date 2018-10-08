package org.laidu.learn.mybatis.annotation.processor;

import com.alibaba.druid.sql.parser.SQLExprParser;
import com.alibaba.druid.sql.parser.SQLParserUtils;
import com.alibaba.druid.util.JdbcUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.laidu.learn.mybatis.annotation.Query;
import org.springframework.stereotype.Component;

/**
 * query 注解处理器
 *
 * @author tiancai.zang
 * on 2018-10-08 19:03.
 */
@Slf4j
@Aspect
@Component
public class QueryProcessor{


    @Pointcut("@annotation(org.laidu.learn.mybatis.annotation.Query)")
    private void pointcut() {
    }

    @Around("pointcut() && @annotation(query)")
    public Object processor(ProceedingJoinPoint joinPoint, Query query) throws Throwable {

        Object result = null;

        String sql = query.sql();

        SQLExprParser sqlParser = SQLParserUtils.createExprParser(sql, JdbcUtils.MYSQL);


        result = joinPoint.proceed();

        return result;

    }
}