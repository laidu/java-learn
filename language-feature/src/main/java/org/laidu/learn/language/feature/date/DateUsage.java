package org.laidu.learn.language.feature.date;

import lombok.extern.slf4j.Slf4j;

import java.time.*;
import java.util.Date;

/**
 * Created by 臧天才 on 2017/8/23 下午4:49.
 */
@Slf4j
public class DateUsage {

    public void text(){


    }


    public static void main(String[] args) {

        // LocalDate usage

        LocalDate localDate = LocalDate.now();

        log.info("-*--*--*--*- 获取当前日期 : {}-*--*--*--*--",localDate);
        log.info("-*--*--*--*- 日 : {}-*--*--*--*--",localDate.getDayOfMonth());
        log.info("-*--*--*--*- 星期 : {}-*--*--*--*--",localDate.getDayOfWeek());

        // LocalTime usage

        LocalTime localTime = LocalTime.now();

        log.info("-*--*--*--*- 获取当前日期 : {}-*--*--*--*--",localTime);


        //Current timestamp
        Instant timestamp = Instant.now();
        System.out.println("Current Timestamp = "+timestamp);

        //Instant from timestamp
        Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
        System.out.println("Specific Time = "+specificTime);

        //Duration example
        Duration thirtyDay = Duration.ofDays(30);
        System.out.println(thirtyDay);

        // ZonedDateTime

        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));

        log.info("-*--*--*--*-zonedDateTime : {}-*--*--*--*--",zonedDateTime.toLocalTime());

        Date date = new Date();


    }
}
