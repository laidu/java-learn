package org.laidu.learn.spring.statemachine.config;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.spring.statemachine.action.PayAdvanceAction;
import org.laidu.learn.spring.statemachine.enums.EventEnum;
import org.laidu.learn.spring.statemachine.enums.OrderStatusEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

/**
 * 状态机配置
 * <p>
 * Created by tiancai.zang
 * on 2018-07-09 22:14.
 */
@Slf4j
@Configuration
@EnableStateMachine
public class StateConfig extends EnumStateMachineConfigurerAdapter<OrderStatusEnum, EventEnum> {


    @Override
    public void configure(StateMachineStateConfigurer<OrderStatusEnum, EventEnum> states) throws Exception {

        states.withStates()
                .initial(OrderStatusEnum.INIT)
                .states(EnumSet.allOf(OrderStatusEnum.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStatusEnum, EventEnum> transitions) throws Exception {
        transitions
                .withExternal()
                .source(OrderStatusEnum.INIT).target(OrderStatusEnum.BOOKING)
                .event(EventEnum.PAY_ADVANCE)
                .action(new PayAdvanceAction())
                .and()
                .withExternal()
                .source(OrderStatusEnum.BOOKING).target(OrderStatusEnum.OVERHANG)
                .event(EventEnum.PAY_OTHER)
                .and()
                .withExternal()
                .source(OrderStatusEnum.OVERHANG).target(OrderStatusEnum.RECEIVING)
                .event(EventEnum.DELIVER_GOODS)
                .and()
                .withExternal()
                .source(OrderStatusEnum.RECEIVING).target(OrderStatusEnum.COMPLETED)
                .event(EventEnum.CONFIRM_RECEIPT)
                .and()
                .withExternal()
                .source(OrderStatusEnum.BOOKING).target(OrderStatusEnum.CANCEL)
                .event(EventEnum.CANCEL)
                .and()
                .withExternal()
                .source(OrderStatusEnum.OVERHANG).target(OrderStatusEnum.CANCEL)
                .event(EventEnum.CANCEL)
        ;
    }
}