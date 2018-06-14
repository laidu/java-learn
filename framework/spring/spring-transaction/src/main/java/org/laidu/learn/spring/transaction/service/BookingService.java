package org.laidu.learn.spring.transaction.service;

import java.util.List;

/**
 * Created by tiancai.zang
 * on 2018-06-13 14:12.
 */
public interface BookingService {

    void book(String... persons);

    List<String> findAllBookings();
}
