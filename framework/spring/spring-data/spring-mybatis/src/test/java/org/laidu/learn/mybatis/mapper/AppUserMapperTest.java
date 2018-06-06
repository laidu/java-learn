package org.laidu.learn.mybatis.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.laidu.learn.mybatis.config.DruidConfig;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(SpringExtension.class)
@Import(DruidConfig.class)
class AppUserMapperTest {

    @Autowired
    AppUserMapper appUserMapper;

    @Autowired
    DruidConfig druidConfig;

    @Test
    void selectAppUserList() {

        appUserMapper.selectAppUserList(1,2).forEach(System.out::println);
    }
}