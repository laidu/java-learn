package org.laidu.learn.mybatis.model.var;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.laidu.learn.mybatis.annotation.Query;

/**
 * 用户变量
 *
 * @author tiancai.zang
 * on 2018-10-08 18:54.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VarAppUser {

    /**
     * 已注册用户数量
     */
    @Query("SELECT COUNT(*) FROM ca_app_user")
    private Integer userCount;

}