package org.laidu.learn.spring.transaction.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookingServiceTest {

    @Autowired
    BookingService bookingService;

    @Test
    void book() {
        bookingService.book("aa","bb","cc");
        Assert.assertEquals(bookingService.findAllBookings().size(),6);

        try {
            bookingService.book("2132313213213");
        } catch (Exception e) {
            Assert.assertEquals(bookingService.findAllBookings().size(),6);
        }


        bookingService.book("123","132");
        Assert.assertEquals(bookingService.findAllBookings().size(),10);

        try {
            bookingService.book("123","123","1dsadsa23");
        } catch (Exception e) {
            Assert.assertEquals(bookingService.findAllBookings().size(),10);
        }


    }

    @Test
    void findAllBookings() {
    }
}