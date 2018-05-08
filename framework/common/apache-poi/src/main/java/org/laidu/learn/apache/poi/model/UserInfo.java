package org.laidu.learn.apache.poi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * user info demo
 * <p>
 * Created by tiancai.zang
 * on 2018-04-28 16:00.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private String username;

    private String password;

    private String address;

    private String email;

    private String realName;
}