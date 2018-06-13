package org.laidu.learn.spring.transaction.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.laidu.learn.spring.transaction.service.BookingService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * booking service impl
 * <p>
 * Created by tiancai.zang
 * on 2018-06-13 14:10.
 *
 * @author tiancai.zang
 */
@Slf4j
@Service
public class BookingServiceImpl implements BookingService {

    private final JdbcTemplate jdbcTemplate;

    public BookingServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void book(String... persons) {

        for (String person : persons) {
            log.info("Booking " + person + " in a seat...");
            jdbcTemplate.update("insert into BOOKINGS(FIRST_NAME) values (?)", person);
        }

        book2(persons);
    }

    @Transactional(propagation = Propagation.NESTED,rollbackFor = Exception.class)
    public void book2(String[] persons) {
        for (String person : persons) {
            log.info("Booking " + person + " in a seat...");
            jdbcTemplate.update("insert into BOOKINGS(FIRST_NAME) values (?)", person);
        }
    }

    @Override
    public List<String> findAllBookings() {
        return jdbcTemplate.query("select FIRST_NAME from BOOKINGS",
                (rs, rowNum) -> rs.getString("FIRST_NAME"));
    }

}