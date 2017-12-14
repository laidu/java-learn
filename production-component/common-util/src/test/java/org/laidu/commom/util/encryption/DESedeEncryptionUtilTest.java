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
        result = DESedeEncryptionUtil.getInstance().cbcEncrypt(palaintext.getBytes(),key.getBytes(), new BigInteger(ivp,16).toByteArray());
        log.info("Base64.encodeToString(result) 's value : {}", Base64.encodeToString(result));

    }

    @Test
    void decrypt() {

        key = "YAYA_FINANCIAL_BANK_APP@";
        ivp = "b069e2e85555e20";
        palaintext = "AppName:44@apiVersion:1.3.0@appCode:KQJK1.3.0@channel:android@pwd:q111111@type:2@userName:13241847378@version:1.3.0";
        cryptograph = "iLVTnl0XdanW1ZoIc+1Qqeiux8fOcyjNdAQ5gsrK83zGg0f1yY5HdvKKpF/QLPgnR+YOngv2VFty/BET9HuzGp6dYu98twcmguE9T689Kr21DbO6HSmBfFCbPxQVYE2hYbqOWikXSJTorsfHznMozRY4ViKNAzFn";

        byte[] result;
        result = DESedeEncryptionUtil.getInstance().cbcDecrypt(Base64.decode(cryptograph),key.getBytes(),new BigInteger(ivp,16).toByteArray());
        log.info("new String(result) 's value : {}", new String(result));
    }


    @Test
    void decrypt1() {

        key = "ab_sdgd_";
        palaintext = "{\"deviceImsi\":\"\",\"deviceUuid\":\"\",\"imei\":\"\",\"ip\":\"\",\"latitude\":\"\",\"loginId\":\"13241487378\",\"longitude\":\"\",\"mac\":\"\",\"password\":\"q1111111\",\"tokenKey\":\"97317bee-4a6b-4063-92ec-c908b47ffe96\"}";
        cryptograph = "uJSRVUSy/p/+QiKHwIh0jXF9PXOcp9lZI/KPlxJv/VC5HPgVNo4bkc1iEmx7zH3rfzd7Uxw/Beva\n" +
                "OxvPbd2bVhKh9u5GMYMPxlBhlM1JmFU532dKd6CWrZ+FxsjfYTe+ho9bj0fN77+g/rQj9QIab8Z8\n" +
                "6UZNSLb19QtCOsgj744uDLNRaiDGvZwO+Al91Kjw8aIgOXgQuNnS3rnF0O/cFUeSgZs+znyAF3M/\n" +
                "13bWqM1zJkbDciHxW99IFdn4TB5m";

        byte[] result;
        result = DESedeEncryptionUtil.getInstance().ecbDecrypt(Base64.decode(cryptograph),key.getBytes());
        log.info("new String(result) 's value : {}", new String(result));
    }

}