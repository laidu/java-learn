package org.laidu.learn.algorithm.encryption;

import jodd.util.Base64;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
class AESUtilTest {


    @BeforeEach
    void setUp() {
    }

    @Test
    void encryptAES() throws Exception {

        //爸爸钱包
        String encrypString = "5LzbdFzcgXpHYzP/MtHpKpqeujNAr7nn05HWALGjudJedauho0G8HRXmgPL9h62PvciQ2NhiQ/j5PPknyP5PYeklspNa3iV5C9hm1/GauWR5nNmNfAjkSNPOe9oCK3ao9kiYlPZwJ+ggxu6sh0esNDJpIB14WjCOL8C+DZuL+lyPJqNNLbtzYeOFSdIdV7fe9vhWarVmGlGo92ATTV48vdNrxujOfhyrDBD9ks5pmY/wRs0RynrmCTEqbO4iECzTSahRtASv186LflijzlsTndK4aQuAOi4Dy+3ZkP04fb+VeO0h6vKVIECzkS/vmyVXIChsSvHesFnVeg5W4axUhnvGICO4xwM3H1t5lxUnnAo=";
        byte[] source = AESUtil.decryptAES(Base64.decode(encrypString),"5O0ItwSgCtrrsuV9C2fRJWDBh2FNGItJ".getBytes(), Hex.decodeHex("00000000000000000000000000000000".toCharArray()));
        log.info("new String(source) 's value : {}", new String(source));

    }

    @Test
    void encryptAES1() throws Exception {

        //百姓钱包
        String encrypString = "2LGhHJ9g7fNVpRcM3MRNA0zALulsd5t4tl3lmvxLo9WClgAkPoNOcSZFpipoXh9cseVoTT6cWwpBqKItUBBsIQ==";
        byte[] source = AESUtil.decryptAES(Base64.decode(encrypString),"418c764b9f0f202d".getBytes(), Base64.decode("NDI0ODI3QTU4NThDQzNCRA=="));
        log.info("new String(source) 's value : {}", new String(source));

    }

    @Test
    void decryptAES2() throws Exception {

        //蜡笔分期
        String encrypString = "YXMwUmh6QzdoamNDMU9FOFBnRTh1TTQwOFdSWVQ4TkF6Ynh6TERIZTZmOTBFMjhJT2NvYUFoUExDOXNYTnMyVGxaUmVXTTM4RWc5OQ0KV0dFcXlBZUlaUUMyUWhqMGtGb2toMXh6ME1EYXAyTGxZRGFKVGRRaVM1S1VYZmhQajFIRWxkcVgrTEhXZXBGb1YvaU9DTXpqbWszdQ0KR2hxcmMxb3haNC9ROEFDY0dVS1VyUXU5eTQweUltSGNaZlpibXUyRHdyTlZqL2lUeXNVdko4NlJyK2dDTDRBcW11SUVGTGZvQzdwVQ0KbUFzTDNndWJFZTRraHBNRTl1QmZEdmlwd09hL2NzVkQybUxvbzYvb0RtWVhPaDNVQWFwZkVaemZFZExjZGZTcEM4d2YzMGtvS2RNeQ0KaFU4bmtJdlFFV0tEY2lWY0FRZFlYbDM1eEJsTHJlUkpscHhHOE5uOFRPWUh4WktEQVhHb2M1N2h4M1k9";
        byte[] source = AESUtil.decryptAES(Base64.decode(Base64.decode(encrypString)),"8183878756300635".getBytes(), "1861218900688990".getBytes());
        log.info("new String(source) 's value : {}", new String(source));

    }

    @Test
    void encryptAES3() throws Exception {

    }

    @Test
    void decryptAES() {
    }

}