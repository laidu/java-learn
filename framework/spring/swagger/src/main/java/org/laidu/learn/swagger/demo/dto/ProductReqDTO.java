package org.laidu.learn.swagger.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
public class ProductReqDTO {

    /**
     * id
     */
    @ApiModelProperty(required = true,name = "产品ID")
    private String  id;

    /**
     * product name
     */
    @ApiModelProperty(required = true,name = "产品ID",allowableValues = "")
    private String name;

    /**
     * product date
     */
    @ApiModelProperty(required = true,example = "2016-01-01")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date productDate;
}