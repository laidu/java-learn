package org.laidu.learn.concurrent.problem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;

/**
 * DateFormat 线程不安全
 *
 * @author zangtiancai.
 * @date 2019-04-09 10:21.
 */
@Slf4j
public class DateFormatDemo {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static void main(String[] args) throws ParseException {

        System.out.println(dateFormat.parse("2017-12-13 15:17:27"));

        IntStream.range(0,100)
                .parallel()
                .forEach(i -> {
                    try {
                        System.out.println(dateFormat.format(dateFormat.parse("2017-12-13 15:17:27")));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                });

    }
}
