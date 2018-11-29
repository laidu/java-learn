package org.laidu.learn.framework.webmagic.renting.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 房源信息
 *
 * @author tiancai.zang
 * on 2018-11-29 17:09.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HouseInfo {

    private String name;

    private String url;

    private Double price;

    private Integer expireElapsed;

    private String destination;

    /**
     * 路线信息
     */
    private String routeInfo;
}