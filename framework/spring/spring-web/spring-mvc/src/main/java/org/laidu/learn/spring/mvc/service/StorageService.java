package org.laidu.learn.spring.mvc.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * 存储service
 * <p>
 * Created by laidu
 * on 2018-10-11 10:40.
 *
 * @author laidu
 */
public interface StorageService {

    void init();

    String store(MultipartFile file);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();
}
