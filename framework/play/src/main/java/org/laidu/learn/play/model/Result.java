package org.laidu.learn.play.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * response result data
 * <p>
 * Created by tiancai.zang on 2017-10-22 11:52.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    private String statusCode;

    private String message;

    private T data;
}