package org.laidu.learn.spring.boot.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * demo
 * <p>
 * Created by tiancai.zang
 * on 2018-05-09 22:57.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DemoDTO {

    private String username;

    private String password;

    private String emailAddress;

    private Long createDate;
}