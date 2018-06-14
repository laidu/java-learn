package org.laidu.commom.util.encryption;

import lombok.extern.slf4j.Slf4j;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 * rsa
 * <p>
 * Created by tiancai.zang on 2017-12-06 10:52.
 */
@Slf4j
public final class RSAencryptionUtil {

    /**
     * Private constructor.
     */
    private RSAencryptionUtil() {
    }

    /**
     * @return Singleton instance
     */
    public static RSAencryptionUtil getInstance() {
        return HelperHolder.INSTANCE;
    }

    /**
     * Provides the lazy-loaded Singleton instance.
     */
    private static class HelperHolder {

        static final String ALGOROTHM_KEY = "RSA";
        static final String PUBLIC_KEY = "RSAPublicKey";
        static final String PRIVATE_KEY = "RSAPrivateKey";

        private static final RSAencryptionUtil INSTANCE =
                new RSAencryptionUtil();
    }



    /**
     * 生成RSA的公钥和私钥
     */
    public  Map<String, Object> initKey() throws Exception{
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        //512-65536 & 64的倍数
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Map<String, Object> keyMap = new HashMap<String, Object>();
        keyMap.put(HelperHolder.PUBLIC_KEY, publicKey);
        keyMap.put(HelperHolder.PRIVATE_KEY, privateKey);

        return keyMap;
    }

    /**
     * 获得公钥
     */
    public  RSAPublicKey getpublicKey(Map<String, Object> keyMap){
        RSAPublicKey publicKey = (RSAPublicKey) keyMap.get(HelperHolder.PUBLIC_KEY);
        return publicKey;
    }

    /**
     * 获得私钥
     */
    public  RSAPrivateKey getPrivateKey(Map<String, Object> keyMap){
        RSAPrivateKey privateKey = (RSAPrivateKey) keyMap.get(HelperHolder.PRIVATE_KEY);
        return privateKey;
    }

    /**
     * 公钥加密
     */
    public  byte[] encrypt(byte[] data, RSAPublicKey publicKey){
        return BasicEncryptionUtil.getInstance().encrypt(HelperHolder.ALGOROTHM_KEY,publicKey,data);
    }

    /**
     * 私钥解密
     */
    public byte[] decrypt(byte[] data, RSAPrivateKey privateKey) throws Exception{
        return BasicEncryptionUtil.getInstance().decrypt(HelperHolder.ALGOROTHM_KEY,privateKey,data);
    }
}

