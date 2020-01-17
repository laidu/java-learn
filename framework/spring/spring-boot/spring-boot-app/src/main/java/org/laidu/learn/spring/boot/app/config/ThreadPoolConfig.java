package org.laidu.learn.spring.boot.app.config;

import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskDecorator;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import lombok.extern.slf4j.Slf4j;

/**
 * 全局线程池配置
 *
 * @author zangtiancai.
 * @date 2019/12/11 下午2:47.
 */
@EnableAsync
@Configuration
public class ThreadPoolConfig {

    public static final String COMMON_FIX_POOL = "commonFixPool";

    @Bean(COMMON_FIX_POOL)
    public Executor commonFixPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(5);
        executor.setKeepAliveSeconds(60);
        executor.setThreadNamePrefix("common-fix-pool-");

        executor.setTaskDecorator(new MdcTaskDecorator());

        // 优雅的关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60);

        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

    @Slf4j
    static class MdcTaskDecorator implements TaskDecorator {

        @Override
        public Runnable decorate(Runnable runnable) {

            Map<String, String> contextMap = MDC.getCopyOfContextMap();
            return () -> {
                try {
                    try {
                        MDC.setContextMap(contextMap);
                    } catch (Exception e) {
                        log.error("设置 mdc error in pool", e);
                    }
                    runnable.run();
                } finally {
                    try {
                        MDC.clear();
                    } catch (Exception e) {
                        log.error("mdc clear 失败", e);
                    }
                }
            };
        }
    }

}
