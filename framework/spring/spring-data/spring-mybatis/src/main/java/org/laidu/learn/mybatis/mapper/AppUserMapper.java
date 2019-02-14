package org.laidu.learn.mybatis.mapper;

import org.apache.ibatis.annotations.*;
import org.laidu.learn.mybatis.entity.AppUser;

import java.util.List;

@Mapper
public interface AppUserMapper {
    @Delete({
        "delete from app_user",
        "where id = #{id}"
    })
    int deleteByPrimaryKey(Long id);

    @Select({
            "select id, username, id_card from app_user ",
            "where 1=1 and id = #{id}"
    })
    AppUser selectByPrimaryKey(Long id);

    @Insert("<script>"  +
            "INSERT INTO app_user(username,id_card) VALUES" +
            "<foreach collection=\"appUsers\" item=\"user\" index=\"index\"  separator=\",\">" +
            "(#{user.username},#{user.idCard})" +
            "</foreach>" +
            "</script>")
    void insertBatch(@Param("appUsers") List<AppUser> appUsers);

}