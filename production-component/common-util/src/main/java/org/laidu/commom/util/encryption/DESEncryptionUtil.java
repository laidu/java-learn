package org.laidu.commom.util.encryption;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


/**
 * DES
 * <p>
 * Created by tiancai.zang on 2017-12-06 10:34.
 */
@Slf4j
public final class DESEncryptionUtil {

    /**
     * Private constructor.
     */
    private DESEncryptionUtil() {
    }

    /**
     * @return Singleton instance
     */
    public static DESEncryptionUtil getInstance() {
        return HelperHolder.INSTANCE;
    }

    /**
     * Provides the lazy-loaded Singleton instance.
     */
    private static class HelperHolder {

        static final String ALGORITHM = "DES";
        static final String ALGORITHM_ECB_KEY = "DES/ECB/PKCS5PADDING";;

        private static final DESEncryptionUtil INSTANCE =
                new DESEncryptionUtil();
    }


    /**
     * 生成密钥
     * @throws Exception
     */
    public  byte[] initKey() throws Exception{
        //密钥生成器
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        //初始化密钥生成器
        keyGen.init(56);
        //生成密钥
        SecretKey  secretKey = keyGen.generateKey();
        return secretKey.getEncoded();
    }

    /**
     * 加密
     * @throws Exception
     */
    public  byte[] ecbEncrypt(byte[] data, byte[] key) {
        SecretKey secretKey = new SecretKeySpec(key, "DES");
        return BasicEncryptionUtil.getInstance().encrypt(secretKey,HelperHolder.ALGORITHM_ECB_KEY,null,data);
    }

    /**
     * 解密
     */
    public  byte[] ecbDecrypt(byte[] data, byte[] key){
        SecretKey secretKey = new SecretKeySpec(key, "DES");
        return BasicEncryptionUtil.getInstance().decrypt(secretKey,HelperHolder.ALGORITHM_ECB_KEY,null,data);
    }
}

