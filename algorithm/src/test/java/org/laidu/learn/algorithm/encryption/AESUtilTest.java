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

        System.out.println(Base64.encodeToString(
                new String(Hex.decodeHex("79311704ccfe4f16befba4d227c9c961e5232f49eb61280a932550ec4960bcbe03a52a70d05af400084e7805a018db898c5b3b24cf5c7636e1fa69f2f348910844ab61638c06584c29edecc7a3c8f96d4ad142124aa11be9e227025dfdd5da19d15c6f876607a47e3e59830cb7f86f15fd634a80f32955f0cdafaa4ca29be33a718860a0ceb3f89654bb3d9a81e5938dd86a01d6c9f2615372a946d19de24e412ea11d97edd79a7c7e31603922d04d9f43f2cc1da6f8ab3823512f24de58e6d8803982be3777cd892d7d0be87278a0eba2f09f8f5be5d25c31d845c98da43dc746bfdebf9dca5320d1d5495e9dd902b33578bd82318056ea5b0490e5487a020a626f3ebf236e96a56136a30a0d12a562526928e0eccd3a28cde1e2cdce5ad02cd6dd7c249e5bfdebbf06958991d874961e0b1f266ccbd66c135410da342837a329bd6a9077ae6430755b749a0a77a5c35a01cf857669b137c8955b006c39114ad19337cfcb410e7ad1bf8ef9581009cf602da09e0aebf9f0843b55dc68feb9cd2834c83f259860148ba44defaf965bbc21c64b89882ebbdc76083b63ae12fd2e5a465b61207a98c48e047e451ea525ad0cd78247b0c16149ab8ff15bf31e0fae8d1395b1ba462edae0ed97cb39a17f1a22631f8ea032a852d325fc26602db907d0906f525dfd387103c3984b2830ea9a".toCharArray()))));
    }

    @Test
    void decryptAES() {
    }

    @Test
    void encryptAESECB(){



    }

}