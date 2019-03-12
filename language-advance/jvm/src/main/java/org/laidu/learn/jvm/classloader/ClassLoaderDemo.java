package org.laidu.learn.jvm.classloader;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

/**
 * class loader
 * <p>
 * Created by tiancai.zang
 * on 2018-05-18 16:20.
 */
@Slf4j
public class ClassLoaderDemo {

    private static PathClassLoader classLoader;
    private static String classPath;

    private final static Map<String,HelloService> serviceMap;

    static {
        String rootDir = System.getProperty("user.dir");
        String projectPath = "/language-advance/jvm/src/main/resources/class/";
        classPath = rootDir+projectPath;
        serviceMap = new ConcurrentHashMap<>();

        classLoader = new PathClassLoader(classPath);
    }

    public static void main(String[] args) throws Exception {
        refresh();

        new ScheduledThreadPoolExecutor(1)
                .scheduleAtFixedRate(() -> {
                    try {
                        log.info("");
                        refresh();
                    } catch (Exception e) {
                      log.error("refresh error : {}",e);
                    }
                }, 0,3, TimeUnit.SECONDS);
    }

    private static void refresh() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 已知classPath为目录名
        File classDir = new File(classPath);
        for (File file : classDir.listFiles(pathname -> pathname.getName().endsWith(".class"))) {
            loadClass(file.getName().replace(".class",""));
        }

        serviceMap.values()
                .forEach(HelloService::sayHello);
    }

    private static void loadClass(String className)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class<?> clazz = classLoader.loadClass(className);
        Object o = clazz.newInstance();

        if (o instanceof HelloService) {
            serviceMap.put(className,(HelloService)o);
        }
    }

}