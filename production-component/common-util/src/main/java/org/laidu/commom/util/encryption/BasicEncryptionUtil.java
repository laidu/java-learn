package org.laidu.commom.util.encryption;

/**
 * java basic encryption util
 * <p>
 * Created by tiancai.zang on 2017-12-05 18:33.
 */
public final class BasicEncryptionUtil {

    /**
     * Private constructor.
     */
    private BasicEncryptionUtil() {
    }

    /**
     * @return Singleton instance
     */
    public static BasicEncryptionUtil getInstance() {
        return HelperHolder.INSTANCE;
    }

    /**
     * Provides the lazy-loaded Singleton instance.
     */
    private static class HelperHolder {
        private static final BasicEncryptionUtil INSTANCE =
                new BasicEncryptionUtil();
    }


//    public static byte[] encryptAES(int mode , byte[] key,  byte[] ivp) throws Exception{
//
//        SecretKey secretKey = new SecretKeySpec(key, "AES");
//        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//        cipher.init(mode, secretKey, new IvParameterSpec(ivp));
////        byte[] encrypt = cipher.doFinal(data);
//
//        return encrypt;
//    }
}

