package org.laidu.commom.util.encryption;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * aes
 * <p>
 * Created by tiancai.zang on 2017-12-06 10:12.
 */
@Slf4j
public final class AESEncryptionUtil {

    /**
     * Private constructor.
     */
    private AESEncryptionUtil() {
    }

    /**
     * @return Singleton instance
     */
    public static AESEncryptionUtil getInstance() {
        return HelperHolder.INSTANCE;
    }

    /**
     * Provides the lazy-loaded Singleton instance.
     */
    @Data
    public  static class HelperHolder {

        static final String ALGORITHM = "AES";
//        static final String ALGORITHM_CBC_KEY = "AES/CBC/PKCS5Padding";
        static final String ALGORITHM_CBC_KEY = "AES/CBC/NoPadding";
        static final String ALGORITHM_ECB_KEY = "AES/ECB/PKCS5Padding";

        private static  final AESEncryptionUtil INSTANCE =
                new AESEncryptionUtil();

        private Object readResolve() {
            return INSTANCE;
        }
    }

//    /**
//     * 生成密钥
//     * @throws Exception
//     */
//    public static byte[] initKey() throws Exception{
//        //密钥生成器
//        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
//        //初始化密钥生成器
//        keyGen.init(128);  //默认128，获得无政策权限后可用192或256
//        //生成密钥
//        SecretKey secretKey = keyGen.generateKey();
//        return secretKey.getEncoded();
//    }

    /**
     * aes cbcEncrypt
     *
     * @param data
     * @param key
     * @param ivp
     * @return
     * @throws Exception
     */
    public byte[] cbcEncrypt(byte[] data, byte[] key, byte[] ivp) {
        return BasicEncryptionUtil.getInstance().encrypt(HelperHolder.ALGORITHM, HelperHolder.ALGORITHM_CBC_KEY, key, ivp, data);
    }

    /**
     * aes cbcDecrypt
     *
     * @param data data
     * @param key  key
     * @param ivp  ivp
     * @return decryption byte array
     * @throws Exception
     */
    public byte[] cbcDecrypt(byte[] data, byte[] key, byte[] ivp) {
        return BasicEncryptionUtil.getInstance().decrypt(HelperHolder.ALGORITHM, HelperHolder.ALGORITHM_CBC_KEY, key, ivp, data);
    }

    /**
     * AES/ECB/PKCS5Padding
     * @param data
     * @param key
     * @return
     */
    public byte[] ecbEncrypt(byte[] data, byte[] key){
        return BasicEncryptionUtil.getInstance().encrypt(HelperHolder.ALGORITHM, HelperHolder.ALGORITHM_ECB_KEY, key, null, data);
    }

    /**
     * AES/ECB/PKCS5Padding
     * @param data
     * @param key
     * @return
     */
    public byte[] ecbDecrypt(byte[] data, byte[] key){
        return BasicEncryptionUtil.getInstance().decrypt(HelperHolder.ALGORITHM, HelperHolder.ALGORITHM_ECB_KEY, key, null, data);
    }

}

