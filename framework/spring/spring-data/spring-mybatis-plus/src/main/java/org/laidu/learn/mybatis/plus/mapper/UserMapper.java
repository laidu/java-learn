package org.laidu.learn.mybatis.plus.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.laidu.learn.mybatis.plus.entity.User;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author zangtiancai.
 * @date 2019-07-12 10:46.
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}