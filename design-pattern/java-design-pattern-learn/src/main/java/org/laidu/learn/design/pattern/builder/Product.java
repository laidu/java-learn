package org.laidu.learn.design.pattern.builder;

import lombok.Data;

import java.util.Date;

/**
 * procuct
 *
 * @author tiancai.zang
 * 2017-12-27 11:08.
 */
// : 2017-12-27 11:08  procuct
@Data
public class Product {

    private String id;
    private String name;
    private Date productData;
}