package org.laidu.commom.util.encryption;

import jodd.util.Base64;
import jodd.util.URLDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
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
    void cbcDecrypt3() throws Exception {

//          * encryptionKey : 0F8A2BF293A1BFEF
//                * encryptionIvp : rst@123456--java
        key = "7E0C6AF28FD219F7";
        ivp = "rst@123456--java";
        palaintext = "{\"f\":\"loginV3\",\"passport\":\"WiT1Q9UXYZMDAKSstQTlAoeW\",\"phone\":\"13241847378\",\"code\":\"\",\"cv\":\"and1.0.0\\/babaqianbao\",\"app\":\"爸爸钱包\",\"sub_app\":\"爸爸钱包_android\",\"phone_token\":\"\",\"password\":\"q11111111\",\"new_password\":\"\",\"ov\":\"and23\",\"place\":\"xiaomi\"}";
        cryptograph = "dnH62L1BODf9DmJMEzptGGl+wmpgPkVe8yCYn8FzxCb80j5/J2Aw0yGCu6TgBCn/ayAUVptOrmuvCuBbolLH8we5d0Vpy5yNTQJYZXISxoQeyQpTkHp7NAn8hCNnEGdqHkcoesp1jADIqvAJfC/BhA==";


        byte[] result = AESEncryptionUtil.getInstance().cbcDecrypt(Base64.decode(cryptograph),key.getBytes(), ivp.getBytes());
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

    @Test
    void ecbDecrypt1() throws DecoderException, UnsupportedEncodingException {

        // 赢彩彩票
        String key = "q9YCl%!3*m#d&3Ke";

        String origin = "{\"imei\":\"869055023868155\",\"mac\":\"02:00:00:00:00:00\",\"accessToken\":\n" +
                "\"\",\"token\":\"ArpdD4m7QnispNeo9hYi02p_CtwKVmGJuSEKSGMD6K5m\",\"channel\":\"1040020\",\"bssid\":\"80:2a:a8:4a:ea:45\",\"version\":\"5.2.46\",\"machineId\":\"Redmi 3\",\"platform\":\"android\",\"osVersion\":\"6.0.1\",\"productName\":\"yccp\",\"isCompress\":\"1\",\"pkgName\":\"com.nibbana.classroom\",\"command\":\"login\",\"requestType\":\"byCodeNew\",\"userName\":\"17091003126\",\"encPassword\":\"0c60df18e1155da1fe4bb7842dff23a6\",\"isAutoLogin\":\"1\",\"key\":\"\",\"code\":\"\",\"state\":\"0\"}";
        String entryptString = "eTEXBMz+Txa++6TSJ8nJYeUjL0nrYSgKkyVQ7ElgvL51WBufU//C71W7hIv5469LIeqJpPyGenZiQbO0feKTwkSrYWOMBlhMKe3sx6PI+W1K0UISSqEb6eInAl391doZ0Vxvh2YHpH4+WYMMt/hvFf1jSoDzKVXwza+qTKKb4zpxiGCgzrP4llS7PZqB5ZONiy/lHcHVAh9c0JGY68Z0nwzYadx5BKYH3JiNzbMwrUND8swdpvirOCNRLyTeWObYgDmCvjd3zYktfQvocnig66Lwn49b5dJcMdhFyY2kPcdGv96/ncpTINHVSV6d2QKzWRmcy8ermMWV3mLe0vwI7mJvPr8jbpalYTajCg0SpWJSaSjg7M06KM3h4s3OWtAs1t18JJ5b/eu/BpWJkdh0lh4LHyZsy9ZsE1QQ2jQoN6MpvWqQd65kMHVbdJoKd6XDWgHPhXZpsTfIlVsAbDkRStGTN8/LQQ560b+O+VgQCc9gLaCeCuv58IQ7Vdxo/rnNKDTIPyWYYBSLpE3vr5ZbvIQ4fHTZwuFy+3n6SYbZqwBiKEvQ43V7LbyBaignzwIs1wn+LHOiZ5dkTnO7lOAAko0TlbG6Ri7a4O2XyzmhfxoiYx+OoDKoUtMl/CZgLbkH0JBvUl39OHEDw5hLKDDqmg==";
        String entryptHex = "79311704ccfe4f16befba4d227c9c961e5232f49eb61280a932550ec4960bcbe75581b9f53ffc2ef55bb848bf9e3af4b21ea89a4fc867a766241b3b47de293c244ab61638c06584c29edecc7a3c8f96d4ad142124aa11be9e227025dfdd5da19d15c6f876607a47e3e59830cb7f86f15fd634a80f32955f0cdafaa4ca29be33a718860a0ceb3f89654bb3d9a81e5938d8b2fe51dc1d5021f5cd09198ebc6749f0cd869dc7904a607dc988dcdb330ad4343f2cc1da6f8ab3823512f24de58e6d8803982be3777cd892d7d0be87278a0eba2f09f8f5be5d25c31d845c98da43dc746bfdebf9dca5320d1d5495e9dd902b359199ccbc7ab98c595de62ded2fc08ee626f3ebf236e96a56136a30a0d12a562526928e0eccd3a28cde1e2cdce5ad02cd6dd7c249e5bfdebbf06958991d874961e0b1f266ccbd66c135410da342837a329bd6a9077ae6430755b749a0a77a5c35a01cf857669b137c8955b006c39114ad19337cfcb410e7ad1bf8ef9581009cf602da09e0aebf9f0843b55dc68feb9cd2834c83f259860148ba44defaf965bbc84387c74d9c2e172fb79fa4986d9ab0062284bd0e3757b2dbc816a2827cf022cd709fe2c73a26797644e73bb94e000928d1395b1ba462edae0ed97cb39a17f1a22631f8ea032a852d325fc26602db907d0906f525dfd387103c3984b2830ea9a";

        byte[] result = AESEncryptionUtil.getInstance().ecbEncrypt(origin.getBytes(),key.getBytes());

        Assert.assertEquals(entryptString,Base64.encodeToString(Hex.decodeHex(entryptHex.toCharArray())));
        Assert.assertEquals(entryptString,Base64.encodeToString(result));
//        System.out.println(entryptString.equals(Base64.encodeToString(result)));
    }

    @Test
    void ecbDecrypt2() throws DecoderException, UnsupportedEncodingException {

        // 众益彩票
        String key = "B4F9CED935M9419D";

        String origin = "";
        String entryptString = "HWygp5ProlS0lQJTsRt4l4YMSX7myufzstgDW+zLWrQUEUZ6MnhqcqeygJlS+lqASjekAo9ytIzX4ivD1AC0M1j0DDJ5AN/x3BTDIlBrSrqHN1qn4NO2aJ61L9Browrj";
        String entryptHex = "1d6ca0a793eba254b4950253b11b7897860c497ee6cae7f3b2d8035beccb5ab41411467a32786a72a7b2809952fa5a804a37a4028f72b48cd7e22bc3d400b43358f40c327900dff1dc14c322506b4aba87375aa7e0d3b6689eb52fd06ba30ae3";

        byte[] result = AESEncryptionUtil.getInstance().ecbDecrypt(Hex.decodeHex(entryptHex.toCharArray()),key.getBytes());

        Assert.assertEquals(entryptString,Base64.encodeToString(Hex.decodeHex(entryptHex.toCharArray())));
//        Assert.assertEquals(entryptString,Base64.encodeToString(result));
        System.out.println(new String(result));
    }

    @Test
    void cfbDecrypt() throws DecoderException, UnsupportedEncodingException {

        // 天天盈球
        String key = "yTEnTOnfqtS+hxFQW4HwsQ==";
        String iv = "\"\"\"\"NNNNttttpppp";

        String origin = "";
        String entryptString = "KR653d2FJEPbmYF//5eNnl/9tWTxOnVMJXBtqhTs5552Dn5y+Z9JNBtS/uNTFgVnD7GfGk2L5C8+JZ0ZSvgH5NADXJbnRfyMfatg1mYtmBE9KUHaNwni9b7vtqXFPJuhdy3R7XtFEVStkV6xHNZbvsha9SBT785MQ6W8y6X9ApQ=";

        byte[] result = AESEncryptionUtil.getInstance().cbcDecrypt(Base64.decode(entryptString),Base64.decode(key),iv.getBytes());

//        Assert.assertEquals(entryptString,Base64.encodeToString(Hex.decodeHex(entryptHex.toCharArray())));
//        Assert.assertEquals(entryptString,Base64.encodeToString(result));

        SecretKey secretKey = new SecretKeySpec(Base64.decode(key), "AES");
        byte[] encrypt = null;

        try {
            Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding");
                cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv.getBytes()));
            encrypt = cipher.doFinal(Base64.decode(entryptString));
        } catch (Exception e) {
        }

        System.out.println(new String(encrypt));
    }

}