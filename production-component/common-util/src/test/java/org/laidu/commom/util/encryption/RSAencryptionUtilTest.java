package org.laidu.commom.util.encryption;

import jodd.util.Base64;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.DecoderException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;

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
        palaintext = "{\"latitude\":\"39.921094\",\"loginName\":\"13241847378\",\"deviceId\":\"fd40d837-7a47-340d-8047-d7882d47ff7f\",\"versionCode\":362,\"loginPwd\":\"903198FC13E1963F30834F0AE04A1ACF\",\"longitude\":\"116.419445      \",\"loginKind\":\"normal\"}";
        cryptograph = "JC8dE6A/GaHt48dkk5QcpFPBh4sgW913s4CFjZIb/0RShdoHgNPHK22Ove11yES4/TE/d+jQXqApGEV4BKr9DsOC4MkOc1+BuUUQyXmzHvU5NQMHVN5U4EH++idWCJZqSU1IdV0cph5+kY4zX0+523Jh0TrzPnA1HeN7ilg3Xw9IWpa8Z/6nKA/yast      DZz3tUzMhcDQvxsonN+Yfb/bIdMJxMvi0KKTnXjvAuISaehv49Ti5n1fv6M2O2awVz+6CMjY8OHn9mxhuivVQpryyK3Bj30VfYqSRtbTYNF0PI4OFUDFI6RFJWJD4G9OqCu8mHdhQYLEgYhH93ttnl2xDfQ==";


        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(bigIntModulus,bigIntPrivateExponent);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyFactory.generatePublic(keySpec);

        byte[] result = null;
        result = RSAencryptionUtil.getInstance().encrypt(palaintext.getBytes(),rsaPublicKey);
        log.info("result 's value : {}", Base64.encodeToString(result));
        result = RSAencryptionUtil.getInstance().encrypt(palaintext.getBytes(),rsaPublicKey);
        log.info("result 's value : {}", Base64.encodeToString(result));
    }

    @Test
    void getPrivateKey() {
    }

    @Test
    void encrypt() throws NoSuchAlgorithmException, InvalidKeySpecException {

        bigIntModulus = new BigInteger("8a3706d24b5f0f0fe96afe4b6180d851bf892612b86a0bd5fe54b3ec6c0151a2307e1e2a21c7bbae0fec5ca317c1e81bdc28abcf776fd62c385594ec6c2859569735591bbac268fdfc7bbee37600e601526d9999b2696fead3d7f147c76dc15aa2c0fb6935478159687596bb546ab63c710f0a160e6d358aafa9027d6cddd303",16);
        bigIntPrivateExponent =new BigInteger("10001",16);
        palaintext = "{\"latitude\":\"39.921094\",\"loginName\":\"13241847378\",\"deviceId\":\"fd40d837-7a47-340d-8047-d7882d47ff7f\",\"versionCode\":362,\"loginPwd\":\"903198FC13E1963F30834F0AE04A1ACF\",\"longitude\":\"116.419445      \",\"loginKind\":\"normal\"}";
        cryptograph = "JC8dE6A/GaHt48dkk5QcpFPBh4sgW913s4CFjZIb/0RShdoHgNPHK22Ove11yES4/TE/d+jQXqApGEV4BKr9DsOC4MkOc1+BuUUQyXmzHvU5NQMHVN5U4EH++idWCJZqSU1IdV0cph5+kY4zX0+523Jh0TrzPnA1HeN7ilg3Xw9IWpa8Z/6nKA/yast      DZz3tUzMhcDQvxsonN+Yfb/bIdMJxMvi0KKTnXjvAuISaehv49Ti5n1fv6M2O2awVz+6CMjY8OHn9mxhuivVQpryyK3Bj30VfYqSRtbTYNF0PI4OFUDFI6RFJWJD4G9OqCu8mHdhQYLEgYhH93ttnl2xDfQ==";


        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(bigIntModulus,bigIntPrivateExponent);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyFactory.generatePublic(keySpec);

        byte[] result = null;
//        result = RSAencryptionUtil.getInstance().cbcEncrypt(palaintext.getBytes(),rsaPublicKey);
        result = RSAencryptionUtil.getInstance().encrypt("13241847378".getBytes(),rsaPublicKey);
        log.info("result 's value : {}", Base64.encodeToString(result));
        result = RSAencryptionUtil.getInstance().encrypt(palaintext.getBytes(),rsaPublicKey);
        log.info("result 's value : {}", Base64.encodeToString(result));
    }

    @Test
    void decrypt() throws Exception {

    }

    @Test
    void getPublicKey() throws Exception {



        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCKNwbSS18PD+lq/kthgNhRv4kmErhqC9X+VLPsbAFRojB+Hiohx7uuD+xcoxfB6BvcKKvPd2/WLDhVlOxsKFlWlzVZG7rCaP38e77jdgDmAVJtmZmyaW/q09fxR8dtwVqiwPtpNUeBWWh1lrtUarY8cQ8KFg5tNYqvqQJ9bN3TAwIDAQAB"));

        RSAPublicKey publicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(keySpec);

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        cipher.init(Cipher.ENCRYPT_MODE,publicKey);

        byte[] result = cipher.doFinal(new BigInteger("7B7D",16).toByteArray());

        System.out.println(Base64.encodeToString(result));


        String cryptograph = "PyTBokP3d9gnntWM\\/iXiDbGvSDcMjqkDZcP6YrQBzrzwCUQfOVHSlt8NHd3NEdnEFsZEBVlHwznh2vfEs5AWT9qxNiTkRgEACP5QpJQPq51htp\\/kG\\/LHKHlGf21Onra80P0gyQ+AYbqMunQOCpf2mh0pbSyw2DGy5nf5iGLzOCw=";


        RSAPrivateKey privateKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(keySpec);
        cipher.init(Cipher.DECRYPT_MODE,privateKey);

        result = cipher.doFinal(Base64.decode(cryptograph));

        System.out.println(Base64.encodeToString(result));


    }

}