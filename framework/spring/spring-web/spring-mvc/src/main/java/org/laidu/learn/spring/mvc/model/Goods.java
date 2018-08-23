package org.laidu.learn.spring.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.laidu.learn.spring.mvc.enums.GoodsTypeEnum;

import java.io.Serializable;

/**
 * 商品
 *
 * @author tiancai.zang
 * on 2018-08-23 11:41.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Goods implements Serializable {

    private static final long serialVersionUID = 4770621416246563806L;

    private Long goodsId;

    private String goodsName;

    private GoodsTypeEnum goodsType;
}