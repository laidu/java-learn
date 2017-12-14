package org.laidu.commom.util.encryption;

import lombok.extern.slf4j.Slf4j;

/**
 * des ede
 * <p>
 * Created by tiancai.zang on 2017-12-06 10:47.
 */
@Slf4j
public final class DESedeEncryptionUtil {

    /**
     * Private constructor.
     */
    private DESedeEncryptionUtil() {
    }

    /**
     * @return Singleton instance
     */
    public static DESedeEncryptionUtil getInstance() {
        return HelperHolder.INSTANCE;
    }

    /**
     * Provides the lazy-loaded Singleton instance.
     */
    private static class HelperHolder {

        /**
         * 密钥算法
         */
        public static final String ALGORITHM = "DESede";

        /**
         * 加密/解密算法/工作模式/填充方式
         */
        public static final String ALGORITHM_CBC_KEY = "DESede/CBC/PKCS5Padding";
        public static final String ALGORITHM_ECB_KEY = "DESede/ECB/PKCS5Padding";

        private static final DESedeEncryptionUtil INSTANCE =
                new DESedeEncryptionUtil();
    }


    /**
     * 加密数据
     *
     * @param data 待加密数据
     * @param key  密钥
     * @return byte[] 加密后的数据
     */
    public byte[] cbcEncrypt(byte[] data, byte[] key, byte[] ivp) {
        return BasicEncryptionUtil.getInstance().encrypt(HelperHolder.ALGORITHM, HelperHolder.ALGORITHM_CBC_KEY, key, ivp, data);
    }

    /**
     * 解密数据
     *
     * @param data 待解密数据
     * @param key  密钥
     * @return byte[] 解密后的数据
     */
    public byte[] cbcDecrypt(byte[] data, byte[] key, byte[] ivp){
        return BasicEncryptionUtil.getInstance().decrypt(HelperHolder.ALGORITHM, HelperHolder.ALGORITHM_CBC_KEY, key, ivp, data);
    }

    /**
     * 加密数据
     *
     * @param data 待加密数据
     * @param key  密钥
     * @return byte[] 加密后的数据
     */
    public byte[] ecbEncrypt(byte[] data, byte[] key) {
        return BasicEncryptionUtil.getInstance().encrypt(HelperHolder.ALGORITHM, HelperHolder.ALGORITHM_ECB_KEY, key, null, data);
    }

    /**
     * 解密数据
     *
     * @param data 待解密数据
     * @param key  密钥
     * @return byte[] 解密后的数据
     */
    public byte[] ecbDecrypt(byte[] data, byte[] key){
        return BasicEncryptionUtil.getInstance().decrypt(HelperHolder.ALGORITHM, HelperHolder.ALGORITHM_ECB_KEY, key, null, data);
    }
}

