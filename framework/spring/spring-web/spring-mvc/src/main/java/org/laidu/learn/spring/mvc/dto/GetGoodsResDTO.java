package org.laidu.learn.spring.mvc.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.laidu.learn.spring.mvc.enums.GoodsTypeEnum;

/**
 * 添加商品DTO
 *
 * @author tiancai.zang
 * on 2018-08-23 11:41.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("添加商品请求")
public class GetGoodsResDTO {

    @ApiModelProperty("商品ID")
    private Long goodsId;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("商品类型")
    private GoodsTypeEnum goodsType;
}