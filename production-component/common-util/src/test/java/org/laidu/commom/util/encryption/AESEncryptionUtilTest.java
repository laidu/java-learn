package org.laidu.commom.util.encryption;

import jodd.util.Base64;
import jodd.util.URLDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
class AESEncryptionUtilTest {

    private String key;
    private String ivp;
    private String palaintext;
    private String cryptograph;

    @BeforeEach
    void setUp() {
        key = "a9876e1ff1e6789a";
        ivp = "CgELBQQPBwkXAwEGCAwNWw==";
        palaintext = "{\"f\":\"loginV3\",\"passport\":\"WiT1Q9UXYZMDAKSstQTlAoeW\",\"phone\":\"13241847378\",\"code\":\"\",\"cv\":\"and1.0.0\\/babaqianbao\",\"app\":\"爸爸钱包\",\"sub_app\":\"爸爸钱包_android\",\"phone_token\":\"\",\"password\":\"q11111111\",\"new_password\":\"\",\"ov\":\"and23\",\"place\":\"xiaomi\"}";
        cryptograph = "eyJvcyI6ImFuZHJvaWQiLCJ2ZXJzaW9uIjoiMy4wLjUiLCJwYWNrYWdlcyI6ImNvbS5pYXNrLmZpbmFuY2VfMS4xLjQiLCJwcm9maWxlX3RpbWUiOjE5NywiaW50ZXJ2YWxfdGltZSI6MTMxNzA0LCJ0b2tlbl9pZCI6IkUzMitEeXJCV2pSRUtDdTlxTnNNdzJPOWk0bFZPeWJDRkJ3c09ZaEJFdzdBeDJUTFdTbHEydlgwVjVaYVlkYjg1WHROaWN3RlpZYVk2TW85WHMrc3hnPT0ifQ==";
    }

    @Test
    void cbcEncrypt() throws DecoderException {
        byte[] result = AESEncryptionUtil.getInstance().cbcEncrypt(palaintext.getBytes(),key.getBytes(), Base64.decode(ivp));
        log.info("result 's value : {}", result);
        Assert.assertEquals(URLDecoder.decode(cryptograph),Base64.encodeToString(result));
    }

    @Test
    void cbcDecrypt() throws Exception {

        byte[] result = AESEncryptionUtil.getInstance().cbcDecrypt(Base64.decode(cryptograph),key.getBytes(), Base64.decode(ivp));
        log.info("result 's value : {}", new String(result));
        Assert.assertEquals(URLDecoder.decode(palaintext),new String(result));
    }


    @Test
    void cbcDecrypt1() throws Exception {

//        String[] strs = {"99","110","56","56","104","110","54","48","99","100","53","57","115","109","115","104"};
//
//        StringBuilder result = new StringBuilder();
//        for(String str : strs){
//            result.append((char)Integer.parseInt(str));
//        }

//        System.out.println(result.toString());

//        byte[] ivp = {0,1,1,2,3,5,8,13,8,7,6,5,4,3,2,1};
        byte[] ivp = {104,110,99,103,99,48,50,109,50,56,112,99,99,98,53,57};
//
        key = "cn88hn60cd59smsh";
//        ivp = "CgELBQQPBwkXAwEGCAwNWw==";
//        palaintext = "{\"f\":\"loginV3\",\"passport\":\"WiT1Q9UXYZMDAKSstQTlAoeW\",\"phone\":\"13241847378\",\"code\":\"\",\"cv\":\"and1.0.0\\/babaqianbao\",\"app\":\"爸爸钱包\",\"sub_app\":\"爸爸钱包_android\",\"phone_token\":\"\",\"password\":\"q11111111\",\"new_password\":\"\",\"ov\":\"and23\",\"place\":\"xiaomi\"}";
        cryptograph = "r1avFQYK6Qwch3kBiqzT2w==";
//        cryptograph = "ZpJ+ykeUPwo=";
//
        byte[] result = AESEncryptionUtil.getInstance().cbcDecrypt(Base64.decode(cryptograph),key.getBytes(), ivp);
        log.info("result 's value : {}", new String(result));
//        Assert.assertEquals(URLDecoder.decode(palaintext),new String(result));
    }


    @Test
    void cbcDecrypt2() throws Exception {

        key = "ABfcG+IlhVTPAsV7eOdApQ==";
        ivp = "AAAAAAAAAAAAAAAAAAAAAA==";
        palaintext = "{\"f\":\"loginV3\",\"passport\":\"WiT1Q9UXYZMDAKSstQTlAoeW\",\"phone\":\"13241847378\",\"code\":\"\",\"cv\":\"and1.0.0\\/babaqianbao\",\"app\":\"爸爸钱包\",\"sub_app\":\"爸爸钱包_android\",\"phone_token\":\"\",\"password\":\"q11111111\",\"new_password\":\"\",\"ov\":\"and23\",\"place\":\"xiaomi\"}";
        cryptograph = "17d2951bd8e0290d7bfb73efb42fdf1ee096941e5fb42d961b54588a38e1abd0afd66481685c89e223d7e6dc7cfd5e82b77859ebb0ca33b041c2dae12b50e05b";


        byte[] result = AESEncryptionUtil.getInstance().cbcDecrypt(Hex.decodeHex(cryptograph.toCharArray()),Base64.decode(key), Base64.decode(ivp));
        log.info("result 's value : {}", new String(result));
//        Assert.assertEquals(URLDecoder.decode(palaintext),new String(result));
    }






}