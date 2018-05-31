package org.laidu.learn.spring.mvc.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * mvc configuration
 * <p>
 * Created by tiancai.zang
 * on 2018-05-30 11:30.
 * @author laidu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@ConfigurationProperties(prefix="org.laidu.learn.spring.mvc.properties")
public class MvcProperties {

    private String appName;

    private String logbackUuid;
}