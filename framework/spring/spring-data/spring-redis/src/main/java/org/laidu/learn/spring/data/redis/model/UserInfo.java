package org.laidu.learn.spring.data.redis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nustaq.serialization.annotations.Serialize;

import java.io.Serializable;

/**
 * user info
 * <p>
 * Created by tiancai.zang
 * on 2018-05-23 14:28.
 * @author laidu
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Serialize
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String username;

//    private String password;

    private String address;
}