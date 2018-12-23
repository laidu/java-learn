package org.laidu.learn.apache.commins.lang3.source;

import org.apache.commons.lang3.Validate;

import java.util.Calendar;
import java.util.Date;

/**
 * DataUtils 部分源码
 */
public class DateUtilsPartMethod {


    /**
     *
     * 此方法实现了 基本的日期计算，是形式为addXXX()方法的具体实现。
     *
     * Adds to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param calendarField  the calendar field to add to
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    private static Date add(final Date date, final int calendarField, final int amount) {
        validateDateNotNull(date);

        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);

        return c.getTime();
    }


    /**
     * <p>Gets a date ceiling, leaving the field specified as the most
     * significant field.</p>
     *
     * <p>For example, if you had the date-time of 28 Mar 2002
     * 13:45:01.231, if you passed with HOUR, it would return 28 Mar
     * 2002 14:00:00.000.  If this was passed with MONTH, it would
     * return 1 Apr 2002 0:00:00.000.</p>
     *
     * @param date  the date to work with, not null
     * @param field  the field from {@code Calendar} or <code>SEMI_MONTH</code>
     * @return the different ceil date, not null
     * @throws IllegalArgumentException if the date is <code>null</code>
     * @throws ArithmeticException if the year is over 280 million
     * @since 2.5
     */
    public static Calendar ceiling(final Calendar date, final int field) {

        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        final Calendar ceiled = (Calendar) date.clone();

//        modify(ceiled, field, DateUtils.ModifyType.CEILING);
        return ceiled;
    }

    private static void validateDateNotNull(final Date date) {
        Validate.isTrue(date != null, "The date must not be null");
    }


}
