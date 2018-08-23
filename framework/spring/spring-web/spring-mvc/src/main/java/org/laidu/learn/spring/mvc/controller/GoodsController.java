package org.laidu.learn.spring.mvc.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.spring.mvc.dto.AddGoodsReqDTO;
import org.laidu.learn.spring.mvc.dto.GetGoodsResDTO;
import org.laidu.learn.spring.mvc.enums.GoodsTypeEnum;
import org.laidu.learn.spring.mvc.model.Goods;
import org.laidu.learn.spring.mvc.model.Result;
import org.laidu.learn.spring.mvc.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品接口
 *
 * @author tiancai.zang
 * on 2018-08-23 11:44.
 */
// TODO: 2018-08-23 11:44  商品接口
@Slf4j
@RestController
@RequestMapping("/goods")
public class GoodsController {

    private final GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @PostMapping("/add")
    @ApiOperation("添加商品")
    public Result<Long> add(@RequestBody AddGoodsReqDTO reqDTO){

        return  Result.ok(goodsService.addGoods(Goods.builder()
                .goodsName(reqDTO.getGoodsName())
                .goodsId(reqDTO.getGoodsId())
                .goodsType(reqDTO.getGoodsType())
                .build()));
    }

    @GetMapping("/query/{goodId}")
    @ApiOperation("查询商品")
    public Result<GetGoodsResDTO> query(@PathVariable("goodId") Long goodId){

        return  Result.ok(GetGoodsResDTO.builder()
                .goodsName("name")
                .goodsId(goodId)
                .goodsType(GoodsTypeEnum.BOOK)
                .build());
    }

}