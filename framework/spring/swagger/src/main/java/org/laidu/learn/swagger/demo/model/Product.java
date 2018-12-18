package org.laidu.learn.swagger.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 产品信息
 *
 * @author tiancai.zang
 * on 2018-11-28 18:45.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    /**
     * id
     */
    public String  id;

    /**
     * product name
     */
    public String name;

    /**
     * product date
     */
    public Date productDate;
}