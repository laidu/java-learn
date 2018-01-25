package org.laidu.commom.util.encryption;

import jodd.util.Base64;
import jodd.util.URLDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

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
        byte[] result = AESEncryptionUtil.getInstance().cbcEncrypt(palaintext.getBytes(), key.getBytes(), Base64.decode(ivp));
        log.info("result 's value : {}", result);
        Assert.assertEquals(URLDecoder.decode(cryptograph), Base64.encodeToString(result));
    }

    @Test
    void cbcDecrypt() throws Exception {

        byte[] result = AESEncryptionUtil.getInstance().cbcDecrypt(Base64.decode(cryptograph), key.getBytes(), Base64.decode(ivp));
        log.info("result 's value : {}", new String(result));
        Assert.assertEquals(URLDecoder.decode(palaintext), new String(result));
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
        byte[] ivp = {104, 110, 99, 103, 99, 48, 50, 109, 50, 56, 112, 99, 99, 98, 53, 57};
//
        key = "cn88hn60cd59smsh";
//        ivp = "CgELBQQPBwkXAwEGCAwNWw==";
//        palaintext = "{\"f\":\"loginV3\",\"passport\":\"WiT1Q9UXYZMDAKSstQTlAoeW\",\"phone\":\"13241847378\",\"code\":\"\",\"cv\":\"and1.0.0\\/babaqianbao\",\"app\":\"爸爸钱包\",\"sub_app\":\"爸爸钱包_android\",\"phone_token\":\"\",\"password\":\"q11111111\",\"new_password\":\"\",\"ov\":\"and23\",\"place\":\"xiaomi\"}";
        cryptograph = "r1avFQYK6Qwch3kBiqzT2w==";
//        cryptograph = "ZpJ+ykeUPwo=";
//
        byte[] result = AESEncryptionUtil.getInstance().cbcDecrypt(Base64.decode(cryptograph), key.getBytes(), ivp);
        log.info("result 's value : {}", new String(result));
//        Assert.assertEquals(URLDecoder.decode(palaintext),new String(result));
    }


    @Test
    void cbcDecrypt2() throws Exception {

        key = "ABfcG+IlhVTPAsV7eOdApQ==";
        ivp = "AAAAAAAAAAAAAAAAAAAAAA==";
        palaintext = "{\"f\":\"loginV3\",\"passport\":\"WiT1Q9UXYZMDAKSstQTlAoeW\",\"phone\":\"13241847378\",\"code\":\"\",\"cv\":\"and1.0.0\\/babaqianbao\",\"app\":\"爸爸钱包\",\"sub_app\":\"爸爸钱包_android\",\"phone_token\":\"\",\"password\":\"q11111111\",\"new_password\":\"\",\"ov\":\"and23\",\"place\":\"xiaomi\"}";
        cryptograph = "17d2951bd8e0290d7bfb73efb42fdf1ee096941e5fb42d961b54588a38e1abd0afd66481685c89e223d7e6dc7cfd5e82b77859ebb0ca33b041c2dae12b50e05b";


        byte[] result = AESEncryptionUtil.getInstance().cbcDecrypt(Hex.decodeHex(cryptograph.toCharArray()), Base64.decode(key), Base64.decode(ivp));
        log.info("result 's value : {}", new String(result));
//        Assert.assertEquals(URLDecoder.decode(palaintext),new String(result));
    }

    @Test
    void ecbDecrypt() throws DecoderException, UnsupportedEncodingException {

//        String source = "eTEXBMz+Txa++6TSJ8nJYeUjL0nrYSgKkyVQ7ElgvL4DpSpw0Fr0AAhOeAWgGNuJjFs7JM9cdjbh+mny80iRCESrYWOMBlhMKe3sx6PI+W1K0UISSqEb6eInAl391doZ0Vxvh2YHpH4+WYMMt/hvFf1jSoDzKVXwza+qTKKb4zpxiGCgzrP4llS7PZqB5ZON2GoB1snyYVNyqUbRneJOQS6hHZft15p8fjFgOSLQTZ9D8swdpvirOCNRLyTeWObYgDmCvjd3zYktfQvocnig66Lwn49b5dJcMdhFyY2kPcdGv96/ncpTINHVSV6d2QKzNXi9gjGAVupbBJDlSHoCCmJvPr8jbpalYTajCg0SpWJSaSjg7M06KM3h4s3OWtAs1t18JJ5b/eu/BpWJkdh0lh4LHyZsy9ZsE1QQ2jQoN6MpvWqQd65kMHVbdJoKd6XDWgHPhXZpsTfIlVsAbDkRStGTN8/LQQ560b+O+VgQCc9gLaCeCuv58IQ7Vdxo/rnNKDTIPyWYYBSLpE3vr5ZbvCHGS4mILrvcdgg7Y64S/S5aRlthIHqYxI4EfkUepSWtDNeCR7DBYUmrj/Fb8x4Pro0TlbG6Ri7a4O2XyzmhfxoiYx+OoDKoUtMl/CZgLbkH0JBvUl39OHEDw5hLKDDqmg==";
        String source = "1d6ca0a793eba254b4950253b11b7897860c497ee6cae7f3b2d8035beccb5ab41411467a32786a72a7b2809952fa5a804a37a4028f72b48cd7e22bc3d400b43358f40c327900dff1dc14c322506b4aba87375aa7e0d3b6689eb52fd06ba30ae3";
        String key = "q9YCl%!3*m#d&3Ke";
//        System.out.println(Hex.encodeHexString(Base64.decode(source)));
        System.out.println(Base64.encodeToString(Hex.decodeHex(source.toCharArray())));

        byte[] result = AESEncryptionUtil.getInstance().ecbDecrypt(Hex.decodeHex(source.toCharArray()),key.getBytes());


        System.out.println("source : "+ new String(AESEncryptionUtil.getInstance().ecbDecrypt(Base64.decode(result),key.getBytes())));
    }


}