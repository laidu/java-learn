package org.laidu.learn.commons.pool.openproxy;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 代理信息
 * <p>
 * Created by tiancai.zang
 * on 2020-07-14 23:30.
 */
@Slf4j
@Data
@Builder
public class ProxyInfo {

    private String ip;
    private Integer port;
    private String schema;
    private LocalDateTime addTime;
    private LocalDateTime verifyTime;

}