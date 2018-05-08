package org.laidu.learn.shiro.reaml.ini;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IniRealmDemoTest {


    @Test
    void helloShiro() {

        String username = "admin";
        String password = "admin";

        IniRealmDemo iniRealmDemo = new IniRealmDemo();

        Assert.assertEquals(true, iniRealmDemo.helloShiro(username, password));
    }
}