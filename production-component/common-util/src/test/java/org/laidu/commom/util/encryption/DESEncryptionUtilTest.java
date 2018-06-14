package org.laidu.commom.util.encryption;

import jodd.util.Base64;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class DESEncryptionUtilTest {



    @Test
    void encryptDES() {

        String key = "ab_sdgd_";
        String plaintext = "{\"deviceImsi\":\"\",\"deviceUuid\":\"\",\"imei\":\"\",\"ip\":\"\",\"latitude\":\"\",\"loginId\":\"13241487379\",\"longitude\":\"\",\"mac\":\"\",\"password\":\"q1111111\",\"tokenKey\":\"97317bee-4a6b-4063-92ec-c908b47ffe96\"}";

        String result = Base64.encodeToString(DESEncryptionUtil.getInstance().ecbEncrypt(plaintext.getBytes(),key.getBytes()));

        log.info("result 's value : {}", result);
    }

    @Test
    void decryptDES() {

        String key = "ab_sdgd_";
        String entryptionString = "BQr0VsH+iN+VZMVameIzwe+Sh7fGW4Pio/gpXIa1vZcny2PsJwusYm9P8PRUkMmSn0O/9c773fCluQVlmx6yLTLoGklijQjCF3/Rw1UHEdqRQwD/r6qFWtOYtvviGhsjsdBhY4sFz9kLqe9k2SXAbfVbQuhD00S4tOdxvlkV/scBtgRmXdklznNGdRtSMEjGNV+n/8D5dvQUpncMmAcq5c8QqUb1CpcjU0Gy+6CkuR9dZaYUA6zpHQ==";

        String result = new String(DESEncryptionUtil.getInstance().ecbDecrypt(Base64.decode(entryptionString),key.getBytes()));

        log.info("result 's value : {}", result);
    }

}