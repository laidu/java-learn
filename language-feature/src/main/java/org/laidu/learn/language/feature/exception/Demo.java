package org.laidu.learn.language.feature.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * demo
 *
 * @author tiancai.zang
 * on 2018-09-11 10:28.
 */
// TODO: 2018-09-11 10:28  demo
@Slf4j
public class Demo {

    public static void main(String[] args) {

        try {
            throw new NullPointerException();
        }catch (Exception e){
            log.info("over");
        }

    }

}