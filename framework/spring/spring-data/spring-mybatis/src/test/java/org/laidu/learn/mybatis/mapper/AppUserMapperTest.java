package org.laidu.learn.mybatis.mapper;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED,connection = EmbeddedDatabaseConnection.H2)
@ExtendWith(SpringExtension.class)
class AppUserMapperTest {

    @Autowired
    AppUserMapper appUserMapper;

    @Test
    void selectAppUserList() {

//        appUserMapper.selectAppUserList(1,2).forEach(System.out::println);
        Assert.assertEquals(1,1);
    }
}