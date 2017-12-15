package org.laidu.learn.swagger.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * product
 * <p>
 *
 * @author tiancai.zang
 * @date 2017-12-10 21:46
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
    public String productDate;
}