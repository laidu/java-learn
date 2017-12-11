package org.laidu.commom.util.encryption;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.DecoderException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;

@Slf4j
class RSAencryptionUtilTest {

    private BigInteger bigIntModulus ;
    private BigInteger bigIntPrivateExponent;
    private String palaintext;
    private String cryptograph;

    @BeforeEach
    void setUp() throws DecoderException {

    }

    @Test
    void getpublicKey() throws NoSuchAlgorithmException, InvalidKeySpecException {

        bigIntModulus = new BigInteger("bcd32d940d9b013a26767c2a60817a275c688cce324f421e40cb4282bb4f914171c7d362d3ecd651c7391ab1999b1b8a440058a869b53c481d9482370d92afc97b2cb955beb214186a060913748140280e9ecbd4af9cac2765efbc6f7a4c5f5d7b2ab183e7eafd2950dd6425a3f386cb82b0a6fc3b2fe7006c9e1c1a665f28f2fdca56b68b14e622abbd7d9a338297a12a1767bb2066d3711c00e9bce485300fb7039e811ec2dda78fbed61047a93f9e6b82627679af87ab64e8d0480d1db4aee110b3423e599c73cddaa98dbfda93b0c6c7dca54a744e9ecbba2cce26aeba293003f03e6496242671c93368fa325cbe346244d7837aa2fdb4eb5e18fcfaf891",16);
        bigIntPrivateExponent =new BigInteger("10001",16);
        palaintext = "{\"account\":\"15638148071\",\"code\":\"d41d8cd98f00b204e9800998ecf8427e\",\"login_type\":\"1\",\"param2\":\"81e15d1b6aebca5b99a7be9079ba19\",\"random_key\":\"bfih\"}";
        cryptograph = "DGNdI9pbHvForT8fAM+c5jQsp/TNQW5/xOlWUrUb5ywH8LS4OEOl4zme7iNqraQ5q/14RShsMi/+\\nVGFgAzueVpE/Ygji6hp1erWuSE8sq5zAP0TLOiEYc+0qlw9yOVoLJ9jSIQ0biQOJSQomr1CmY1GR\\nLK8/Ixr46z50XDfjS65TytTDdB5oTF/dIpu5yjhMbreazIUNi/7mgTsxHxgdQG101fMBNhvjjtg6\\n5QUgk5ruqfaH6/QDwiMwX/iJGDg0Hd8ltS9rVP9JL15V4Z0UoWEwZ5gBnWX6NLpY7NPXrLEx/dxz\\nm7DnvBd93mHBGXjNjRJJ5P8XqGtqhZv+UNjomSPzSws5eVI5CBya4PH33Sowdx0OzSyu859E5KZy\\nDbIejZAeO4NSzjMRnF0AVHsJzWHkt6rimP9OpAoPPdoDTT/xPjocZ+M3+TOYA7omDNw541ds2Uas\\nfSvVLdD2jw0QDRfkOV5gbeII45a07qUPSznUwALgMRiIIJFEmCSDu6YOK1oVQ71SoBTMw1am8bk+\\nFAvXIEDJOIPf21MzRGr472MYxdchkLNkFK0nu4CsYwuHGA95d2JIFYXLAc1AKjg/7xuEPpGKHl5q\\nlYIP90JU725iRX/DKuDz+dBYfY5LkoGavDmRHVfu7uHxlGKVwnkmjXGBzw/0dG28mtynzjFGy40=";


        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(bigIntModulus,bigIntPrivateExponent);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyFactory.generatePublic(keySpec);

        byte[] result = null;
        result = RSAencryptionUtil.getInstance().encrypt(palaintext.getBytes(),rsaPublicKey);
        log.info("result 's value : {}", jodd.util.Base64.encodeToString(result));
        result = RSAencryptionUtil.getInstance().encrypt(palaintext.getBytes(),rsaPublicKey);
        log.info("result 's value : {}", jodd.util.Base64.encodeToString(result));
    }

    @Test
    void getPrivateKey() {
    }

    @Test
    void encrypt() throws NoSuchAlgorithmException, InvalidKeySpecException {

        bigIntModulus = new BigInteger("8a3706d24b5f0f0fe96afe4b6180d851bf892612b86a0bd5fe54b3ec6c0151a2307e1e2a21c7bbae0fec5ca317c1e81bdc28abcf776fd62c385594ec6c2859569735591bbac268fdfc7bbee37600e601526d9999b2696fead3d7f147c76dc15aa2c0fb6935478159687596bb546ab63c710f0a160e6d358aafa9027d6cddd303",16);
        bigIntPrivateExponent =new BigInteger("10001",16);
        palaintext = "{\"latitude\":\"39.921104\",\"loginName\":\"13241847378\",\"deviceId\":\"fd40d837-7a47-340d-8047-d7882d47ff7f\",\"versionCode\":362,\"loginPwd\":\"481E15D1B6AEBCA5B99A7BE9079BA192\",\"longitude\":\"116.419451\",\"loginKind\":\"normal\"}";
        cryptograph = "DGNdI9pbHvForT8fAM+c5jQsp/TNQW5/xOlWUrUb5ywH8LS4OEOl4zme7iNqraQ5q/14RShsMi/+\\nVGFgAzueVpE/Ygji6hp1erWuSE8sq5zAP0TLOiEYc+0qlw9yOVoLJ9jSIQ0biQOJSQomr1CmY1GR\\nLK8/Ixr46z50XDfjS65TytTDdB5oTF/dIpu5yjhMbreazIUNi/7mgTsxHxgdQG101fMBNhvjjtg6\\n5QUgk5ruqfaH6/QDwiMwX/iJGDg0Hd8ltS9rVP9JL15V4Z0UoWEwZ5gBnWX6NLpY7NPXrLEx/dxz\\nm7DnvBd93mHBGXjNjRJJ5P8XqGtqhZv+UNjomSPzSws5eVI5CBya4PH33Sowdx0OzSyu859E5KZy\\nDbIejZAeO4NSzjMRnF0AVHsJzWHkt6rimP9OpAoPPdoDTT/xPjocZ+M3+TOYA7omDNw541ds2Uas\\nfSvVLdD2jw0QDRfkOV5gbeII45a07qUPSznUwALgMRiIIJFEmCSDu6YOK1oVQ71SoBTMw1am8bk+\\nFAvXIEDJOIPf21MzRGr472MYxdchkLNkFK0nu4CsYwuHGA95d2JIFYXLAc1AKjg/7xuEPpGKHl5q\\nlYIP90JU725iRX/DKuDz+dBYfY5LkoGavDmRHVfu7uHxlGKVwnkmjXGBzw/0dG28mtynzjFGy40=";


        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(bigIntModulus,bigIntPrivateExponent);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyFactory.generatePublic(keySpec);

        byte[] result = null;
//        result = RSAencryptionUtil.getInstance().encrypt(palaintext.getBytes(),rsaPublicKey);
        result = RSAencryptionUtil.getInstance().encrypt("13241847378".getBytes(),rsaPublicKey);
        log.info("result 's value : {}", jodd.util.Base64.encodeToString(result));
        result = RSAencryptionUtil.getInstance().encrypt(palaintext.getBytes(),rsaPublicKey);
        log.info("result 's value : {}", jodd.util.Base64.encodeToString(result));
    }

    @Test
    void decrypt() throws Exception {

    }

}