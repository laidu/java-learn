package org.laidu.learn.jvm.exception;

import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;

/**
 * 空指针异常堆栈忽略demo
 * 禁用优化：-XX:-OmitStackTraceInFastThrow
 *
 * @author zangtiancai.
 * @date 2019-04-04 16:06.
 */
@Slf4j
public class NPExceptionDemo {

    private static  Exception e = new BusinessException();

    public static void main(String[] args) {


        IntStream.range(0, Integer.MAX_VALUE).forEach(i -> {
            try {
                work(i);
            } catch (Exception e1) {
                log.error("i's value : {}", i, e1);
            }

        });

    }

    private static void work(int i) throws Exception {
        //        String a = null;
        //        a.length();
        throw e;

    }

    public static class BusinessException extends RuntimeException {

    }
}
