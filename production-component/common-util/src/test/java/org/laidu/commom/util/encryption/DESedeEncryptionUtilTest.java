package org.laidu.commom.util.encryption;

import jodd.util.Base64;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.DecoderException;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

@Slf4j
class DESedeEncryptionUtilTest {

    private String key;
    private String ivp;
    private String palaintext;
    private String cryptograph;

//    @BeforeEach
    void setUp() {
        key = "YAYA_FINANCIAL_BANK_APP@";
        ivp = "b069e2e85555e20";
        palaintext = "AppName:44@apiVersion:1.3.0@appCode:KQJK1.3.0@channel:android@pwd:q111111@type:2@userName:13241847378@version:1.3.0";
        cryptograph = "iLVTnl0XdanW1ZoIc+1Qqeiux8fOcyjNdAQ5gsrK83zGg0f1yY5HdvKKpF/QLPgnR+YOngv2VFty/BET9HuzGp6dYu98twcmguE9T689Kr21DbO6HSmBfFCbPxQVYE2hYbqOWikXSJTorsfHznMozRY4ViKNAzFn";
    }

    @Test
    void encrypt() throws DecoderException {

        key = "YAYA_FINANCIAL_BANK_APP@";
        ivp = "b069e2e85555e20";
        palaintext = "AppName:44@apiVersion:1.3.0@appCode:KQJK1.3.0@channel:android@pwd:q111111@type:2@userName:13241847378@version:1.3.0";
        cryptograph = "iLVTnl0XdanW1ZoIc+1Qqeiux8fOcyjNdAQ5gsrK83zGg0f1yY5HdvKKpF/QLPgnR+YOngv2VFty/BET9HuzGp6dYu98twcmguE9T689Kr21DbO6HSmBfFCbPxQVYE2hYbqOWikXSJTorsfHznMozRY4ViKNAzFn";

        byte[]  result;
        result = DESedeEncryptionUtil.getInstance().encrypt(palaintext.getBytes(),key.getBytes(), new BigInteger(ivp,16).toByteArray());
        log.info("Base64.encodeToString(result) 's value : {}", Base64.encodeToString(result));

    }

    @Test
    void decrypt() {

        key = "YAYA_FINANCIAL_BANK_APP@";
        ivp = "b069e2e85555e20";
        palaintext = "AppName:44@apiVersion:1.3.0@appCode:KQJK1.3.0@channel:android@pwd:q111111@type:2@userName:13241847378@version:1.3.0";
        cryptograph = "iLVTnl0XdanW1ZoIc+1Qqeiux8fOcyjNdAQ5gsrK83zGg0f1yY5HdvKKpF/QLPgnR+YOngv2VFty/BET9HuzGp6dYu98twcmguE9T689Kr21DbO6HSmBfFCbPxQVYE2hYbqOWikXSJTorsfHznMozRY4ViKNAzFn";

        byte[] result;
        result = DESedeEncryptionUtil.getInstance().decrypt(Base64.decode(cryptograph),key.getBytes(),new BigInteger(ivp,16).toByteArray());
        log.info("new String(result) 's value : {}", new String(result));
    }

}