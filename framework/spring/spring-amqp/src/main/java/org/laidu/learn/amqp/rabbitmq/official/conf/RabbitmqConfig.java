package org.laidu.learn.amqp.rabbitmq.official.conf;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RabbitmqConfig
 * <p>
 * Created by tiancai.zang on 2017-11-28 14:47.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RabbitmqConfig {

    private String host;
    private String port;
    private String username;
    private String password;
    private String virtualHost;
}