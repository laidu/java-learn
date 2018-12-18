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

    private HouseDetail detail;

    private String url;

    private Double price;

    /**
     * 路线信息
     */
    private String routeInfo;

    /**
     * 面积： 13.3 ㎡
     * 朝向： 南
     * 户型： 3室1厅 合
     * 楼层： 15/15层
     * 交通： 距房山线良乡南关686米
     * 距房山线良乡大学城西759米
     *
     * 距房山线苏庄1959米
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class HouseDetail{

        private String locationName;

        /**
         * 经度
         */
        private Double longitude;

        /**
         * 纬度
         */
        private Double latitude;

        /**
         * 面积
         */
        private String areaSize;


        /**
         * 朝向
         */
        private String toward;

        /**
         * 户型信息
         */
        private String unit;

        /**
         * 楼层信息
         */
        private String floor;

        /**
         * 交通信息
         */
        private String traffic;
    }
}