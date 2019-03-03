package org.laidu.learn.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppUser implements Serializable {
    private Long id;

    private String username;

    private String idCard;

    private static final long serialVersionUID = 1L;
}