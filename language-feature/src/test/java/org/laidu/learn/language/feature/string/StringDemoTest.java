package org.laidu.learn.language.feature.string;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class StringDemoTest {

    @Test
    void createString() {
        String hexString  = "f09f9880";
        byte[] val = new byte[hexString.length() / 2];
        for (int i = 0; i < val.length; i++) {
            int index = i * 2;
            int j = Integer.parseInt(hexString.substring(index, index + 2), 16);
            val[i] = (byte) j;
        }
        log.info("hexString 2 String : {}",new String(val));

    }
}