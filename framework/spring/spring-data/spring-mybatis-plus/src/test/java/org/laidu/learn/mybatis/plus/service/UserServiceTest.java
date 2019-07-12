package org.laidu.learn.mybatis.plus.service;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.laidu.learn.mybatis.plus.entity.User;
import org.laidu.learn.mybatis.plus.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = mapper.selectList(null);

        IPage<User> selectPage = mapper.selectPage(new Page<>(1, 1), null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void lambdaPagination() {
        Page<User> page = new Page<>(1, 3);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().ge(User::getAge, 1);
        IPage<User> result = mapper.selectPage(page, wrapper);
        System.out.println(result.getTotal());
        Assert.assertTrue(result.getTotal() > 3);
        Assert.assertEquals(3, result.getRecords().size());
    }

}