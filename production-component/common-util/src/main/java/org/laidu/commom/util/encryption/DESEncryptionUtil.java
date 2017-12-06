package org.laidu.commom.util.encryption;

import lombok.extern.slf4j.Slf4j;

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
        static final String ALGORITHM_KEY = "DES";
        static final String ALGORITHM_EDE_KEY = "DES";

        private static final DESEncryptionUtil INSTANCE =
                new DESEncryptionUtil();
    }

//
//    /**
//     * 生成密钥
//     * @throws Exception
//     */
//    public  byte[] initKey() throws Exception{
//        //密钥生成器
//        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
//        //初始化密钥生成器
//        keyGen.init(56);
//        //生成密钥
//        SecretKey secretKey = keyGen.generateKey();
//        return secretKey.getEncoded();
//    }

    /**
     * 加密
     *
     * @throws Exception
     */
    public byte[] desEncrypt(byte[] data, byte[] key) throws Exception {
        return BasicEncryptionUtil.getInstance().encrypt(HelperHolder.ALGORITHM, HelperHolder.ALGORITHM_KEY, key, null, data);
    }

    /**
     * 解密
     */
    public byte[] desDecryptDES(byte[] data, byte[] key) throws Exception {
        return BasicEncryptionUtil.getInstance().decrypt(HelperHolder.ALGORITHM, HelperHolder.ALGORITHM_KEY, key, null, data);
    }
}

