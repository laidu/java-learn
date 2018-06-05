package org.laidu.learn.spring.mvc.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * mvc configuration
 * <p>
 * Created by tiancai.zang
 * on 2018-05-30 11:30.
 * @author laidu
 */
@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "mvc")
public class MvcProperties {

    private String appName;

    private String logbackUuid;
}