package org.laidu.learn.spring.statemachine.enums;

/**
 * 订单状态
 * <p>
 * Created by laidu
 * on 2018-07-09 19:42.
 *
 * @author laidu
 */
public enum  OrderStatusEnum {

    /**
     * 初始状态
     */
    INIT,

    /**
     * 预定
     */
    BOOKING,

    /**
     * 待发货
     */
    OVERHANG,

    /**
     * 待收货
     */
    RECEIVING,

    /**
     * 取消
     */
    CANCEL,

    /**
     * 完成
     */
    COMPLETED,

    ;
}