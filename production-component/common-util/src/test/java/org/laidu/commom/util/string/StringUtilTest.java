package org.laidu.commom.util.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class StringUtilTest {

    @Test
    void snakeCasetranslate() {

        String input = "idCard";

        String result = StringUtil.INSTANCE.toSnakeCase(input);
        
        log.info("result: {}", result);

        String result2 = StringUtil.INSTANCE.toCamelCase(result);

        log.info("result2: {}", result2);
    }
}