package org.laidu.learn.spring.mvc.controller;

import org.apiguardian.api.API;
import org.laidu.learn.spring.mvc.dto.AddGoodsReqDTO;
import org.laidu.learn.spring.mvc.dto.GetGoodsResDTO;
import org.laidu.learn.spring.mvc.enums.GoodsTypeEnum;
import org.laidu.learn.spring.mvc.model.Goods;
import org.laidu.learn.spring.mvc.model.Response;
import org.laidu.learn.spring.mvc.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

/**
 * 商品接口
 *
 * @author tiancai.zang
 * on 2018-08-23 11:44.
 */
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
    @Operation(method = "添加商品")
    public Response<Long> add(@RequestBody AddGoodsReqDTO reqDTO){

        return  Response.ok(goodsService.addGoods(Goods.builder()
                .goodsName(reqDTO.getGoodsName())
                .goodsId(reqDTO.getGoodsId())
                .goodsType(reqDTO.getGoodsType())
                .build()));
    }

    @GetMapping("/query/{goodId}")
    @Operation(method = "查询商品")
    public Response<GetGoodsResDTO> query(@PathVariable("goodId") Long goodId){

        return  Response.ok(GetGoodsResDTO.builder()
                .goodsName("name")
                .goodsId(goodId)
                .goodsType(GoodsTypeEnum.BOOK_0)
                .build());
    }



}