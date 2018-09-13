package org.laidu.learn.spring.spel.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * spel DEMO
 *
 * @author tiancai.zang
 * on 2018-09-13 14:25.
 */
@Slf4j
public class Demo {

    public static final String DEMO = "DEMO";

    public static void main(String[] args) {

        String spelString = "SELECT COUNT(*) FROM fact_ca_order WHERE deliver_status=2 AND cancel_status = 0 AND flag = #{flag} AND flag1 = '#{flagName}';";
//        String spelString = "${sql:SELECT COUNT(*) FROM fact_ca_order WHERE deliver_status=2 AND cancel_status = 0}";

        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext();


        Expression expression = parser.parseExpression(spelString,new TemplateParserContext());

        System.out.println(expression.getValue(new Flag(123,"flagName")));
    }

    @AllArgsConstructor
    @Data
    public static class Flag{
        private int flag;
        private String flagName;
    }

    public static class TemplateParserContext implements ParserContext {

        @Override
        public boolean isTemplate() {
            return true;
        }

        @Override
        public String getExpressionPrefix() {
            return "#{";
        }

        @Override
        public String getExpressionSuffix() {
            return "}";
        }
    }
}