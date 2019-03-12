package org.laidu.learn.jvm.classloader;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 根据路径加载class文件
 * <p>
 * Created by tiancai.zang
 * on 2019-03-12 22:33.
 */
@Slf4j
@AllArgsConstructor
public class PathClassLoader extends ClassLoader{

    private String classPath;

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] data = getData(name);

        if (data == null) {
            throw new ClassNotFoundException(name);
        }

        return super.defineClass(
                name,
                data, 0, data.length,
                this.getClass().getProtectionDomain()
        );

    }


    public byte[] getData(String name) {

        String suffix = name.endsWith(".class") ? "" : ".class";

        String path = classPath + name.replace(".", File.pathSeparator) + suffix;

        byte[] bytes = null;

        try(FileInputStream inputStream =  new FileInputStream(new File(path))) {
            bytes = IOUtils.toByteArray(inputStream);
        } catch (Exception e) {
            log.error("file not found! : {}",path);
        }

        return bytes;
    }
}