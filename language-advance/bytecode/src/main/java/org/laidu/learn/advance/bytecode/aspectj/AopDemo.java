package org.laidu.learn.advance.bytecode.aspectj;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tiancai.zang
 * on 2018-08-28 19:09.
 */
@Slf4j
public class AopDemo {


    public static void main(String[] args) {

        UserService userService = new UserService();
        System.out.println(userService.fetchUserById(234));
    }

    public static class UserService {

        @LogStartTime("Hello World")
        private final String fetchUserById(int userId) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("start time: " + MethodStartAspect.getStartTime());

            return "nameOf" + userId;
        }
    }
}