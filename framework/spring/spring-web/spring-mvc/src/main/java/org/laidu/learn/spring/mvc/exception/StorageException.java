package org.laidu.learn.spring.mvc.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * StorageException
 *
 * @author tiancai.zang
 * on 2018-10-11 11:12.
 */
@Slf4j
public class StorageException  extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}