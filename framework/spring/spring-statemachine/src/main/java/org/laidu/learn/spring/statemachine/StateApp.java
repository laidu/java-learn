package org.laidu.learn.spring.statemachine;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.spring.statemachine.enums.EventEnum;
import org.laidu.learn.spring.statemachine.enums.OrderStatusEnum;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.statemachine.StateMachine;

/**
 * 状态机
 * <p>
 * Created by tiancai.zang
 * on 2018-07-09 22:33.
 */
@Slf4j
@SpringBootApplication
public class StateApp {


    public static void main(String[] args) {

        ApplicationContext context =  new SpringApplicationBuilder(StateApp.class)
                .build().run(args);

        StateMachine<OrderStatusEnum, EventEnum> stateMachine = context.getBean(StateMachine.class);

        stateMachine.start();
        stateMachine.sendEvent(EventEnum.PAY_ADVANCE);
        stateMachine.sendEvent(EventEnum.PAY_OTHER);

    }

}