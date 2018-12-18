package org.laidu.learn.framework.webmagic.renting.conf;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 租房需求配置
 *
 * @author tiancai.zang
 * on 2018-11-29 17:03.
 */
@Slf4j
@Data
@Builder
public class RequirementConf {

    /**
     * 价格上线
     */
    private Double highPrice;

    /**
     * 价格下线
     */
    private Double lowPrice = 0.0;

    /**
     * 目的地
     */
    private String destination;

    /**
     * 期望耗时（分钟）
     */
    private Integer expireElapsed;
}