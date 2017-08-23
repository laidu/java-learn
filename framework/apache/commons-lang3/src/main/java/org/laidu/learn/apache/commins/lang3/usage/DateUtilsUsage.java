package org.laidu.learn.apache.commins.lang3.usage;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

/**
 * DateUtils 使用
 */
@Slf4j
public class DateUtilsUsage {

    public static void main(String[] args) {

        log.info("-*--*--*--*- 一秒的豪秒数 : {}-*--*--*--*--", DateUtils.MILLIS_PER_SECOND);
        log.info("-*--*--*--*- 一天的豪秒数 : {}-*--*--*--*--", DateUtils.MILLIS_PER_DAY);

        Date currentDate = new Date();

    }
}
