package org.laidu.learn.swagger.demo.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema
public class ProductResDTO {

    /**
     * id
     */
    private String id;

    /**
     * product name
     */
    private String name;

    /**
     * product date
     */
    @NotNull
    @Schema( example = "2016-01-01 18:10:12")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Date productDate;
}