package org.laidu.learn.spring.mvc.dto;

import org.laidu.learn.spring.mvc.enums.GoodsTypeEnum;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class GetGoodsResDTO {

    @Parameter(name = "商品ID")
    private Long goodsId;

    @Parameter(name = "商品名称")
    private String goodsName;

    @Parameter(name = "商品类型")
    private GoodsTypeEnum goodsType;
}