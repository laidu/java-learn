package org.laidu.learn.spring.statemachine.action;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.spring.statemachine.enums.EventEnum;
import org.laidu.learn.spring.statemachine.enums.OrderStatusEnum;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * 支付动作
 * <p>
 * Created by tiancai.zang
 * on 2018-07-09 22:29.
 */
@Slf4j
@WithStateMachine
public class PayAdvanceAction implements Action<OrderStatusEnum, EventEnum> {

    @Override
    public void execute(StateContext<OrderStatusEnum, EventEnum> context) {

        log.info("支付预付款");
    }
}