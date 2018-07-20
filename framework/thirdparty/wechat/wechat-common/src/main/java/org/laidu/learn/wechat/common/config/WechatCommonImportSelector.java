package org.laidu.learn.wechat.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 微信
 * <p>
 * Created by laidu
 * on 2018-07-20 14:56.
 *
 * @author laidu
 */
// TODO: 2018-07-20 14:56  微信
@Slf4j
public class WechatCommonImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{WechatProperties.class.getName()};
    }
}