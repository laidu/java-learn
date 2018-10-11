package org.laidu.learn.spring.mvc.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * StorageFileNotFoundException
 *
 * @author tiancai.zang
 * on 2018-10-11 11:12.
 */
@Slf4j
public class StorageFileNotFoundException extends StorageException {

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}