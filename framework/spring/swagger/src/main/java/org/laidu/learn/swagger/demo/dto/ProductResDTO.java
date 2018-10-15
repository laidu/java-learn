package org.laidu.learn.swagger.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
@ApiModel
public class ProductResDTO {

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
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    public Date productDate;
}