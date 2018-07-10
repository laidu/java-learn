package org.laidu.learn.spring.statemachine.enums;

/**
 * 事件类型
 * <p>
 * Created by laidu
 * on 2018-07-09 19:46.
 *
 * @author laidu
 */
public enum  EventEnum {

    /**
     * 支付预订款
     */
    PAY_ADVANCE,

    /**
     * 支付余款
     */
    PAY_OTHER,

    /**
     * 卖家发货
     */
    DELIVER_GOODS,

    /**
     * 买家确认收货
     */
    CONFIRM_RECEIPT,

    /**
     * 取消
     */
    CANCEL,

    ;
}