package org.laidu.learn.webfulx.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Created by tiancai.zang
 * on 2018-06-11 23:22.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HelloModel {

    private String username;

    private LocalDate currentDate;

    private String message;
}