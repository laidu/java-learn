package org.laidu.learn.shiro.reaml.ini;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;


/**
 * Created by tiancai.zang
 * on 2018-05-08 11:10.
 */
@Slf4j
public class IniRealmDemo {


    private final static String iniResourcePath = "classpath:shiro.ini";

    public boolean helloShiro(String username, String password) {

        /**
         * step 0 : SecurityMannger
         */
        initSecurityUtils();

        /**
         * Step 1: Collect the Subject’s principals and credentials
         */

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        usernamePasswordToken.setRememberMe(true);

        /**
         * Step 2: Submit the principals and credentials
         */
        Subject currentUser = SecurityUtils.getSubject();

        try {
            currentUser.login(usernamePasswordToken);
            log.debug("currentUser.isAuthenticated()'s value : {}", currentUser.isAuthenticated());
        } catch (Exception e) {
            log.error("usernamePasswordToken's value : {}", usernamePasswordToken);
        }

        return currentUser.isAuthenticated();

    }

    private static void initSecurityUtils() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(iniResourcePath);
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
    }

}