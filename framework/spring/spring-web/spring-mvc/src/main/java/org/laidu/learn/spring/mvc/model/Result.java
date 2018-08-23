package org.laidu.learn.spring.mvc.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接口返回值封装
 * <p>
 * Created by laidu
 * on 2018-08-02 17:48.
 *
 * @author laidu
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description ="响应封装")
public class Result<T> {

    private String code;

    private String message;

    private T data;

    public static <T> Result<T> ok(T data){

        return Result.<T>builder()
                .code("E000000")
                .message("success")
                .data(data)
                .build();
    }
}