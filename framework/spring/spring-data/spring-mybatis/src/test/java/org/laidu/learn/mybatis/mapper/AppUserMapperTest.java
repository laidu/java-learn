package org.laidu.learn.mybatis.mapper;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.laidu.learn.mybatis.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED,connection = EmbeddedDatabaseConnection.H2)
@ExtendWith(SpringExtension.class)
class AppUserMapperTest {

    @Autowired
    AppUserMapper appUserMapper;

    @Test
    void selectAppUserList() {

        AppUser appUser = appUserMapper.selectByPrimaryKey(1L);
        Assert.assertNotNull(appUser.getId());

        List<AppUser> appUserList = Arrays.asList(appUser,appUser,appUser,appUser);

        appUserMapper.insertBatch(appUserList);

        AppUser appUser1 = appUserMapper.selectByPrimaryKey(3L);
        Assert.assertNotNull(appUser1);


    }
}