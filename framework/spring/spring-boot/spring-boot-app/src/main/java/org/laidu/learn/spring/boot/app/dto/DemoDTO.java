package org.laidu.learn.spring.boot.app.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * demo
 * <p>
 * Created by tiancai.zang
 * on 2018-05-09 22:57.
 * @author laidu
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DemoDTO {

    private String username;

    private String password;

    private String emailAddress;

    private Long createDate;
}