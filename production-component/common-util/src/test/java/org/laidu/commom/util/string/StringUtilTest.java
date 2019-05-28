package org.laidu.commom.util.string;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

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

    @Test
    void numberParse(){

        String str1 = "1#01231231";
        Assert.assertEquals(0L, NumberUtils.toLong(str1));

        str1 = "123123";
        Assert.assertEquals(123123L, NumberUtils.toLong(str1));

        str1 = "0x1";
        Assert.assertEquals(0L, NumberUtils.toLong(str1));

        str1 = "123122222222321L";
        Assert.assertEquals(0L, NumberUtils.toLong(str1));
    }
}