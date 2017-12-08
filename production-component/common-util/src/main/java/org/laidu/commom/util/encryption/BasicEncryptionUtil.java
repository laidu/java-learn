package org.laidu.commom.util.encryption;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;

/**
 * java basic encryption util
 * <p>
 * Created by tiancai.zang on 2017-12-05 18:33.
 */
@Slf4j
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

    /**
     * encrypt
     * @param algorithm
     * @param algorithmKey
     * @param key
     * @param ivp
     * @param data
     * @return
     * @throws Exception
     */
    public  byte[] encrypt(String algorithm,String algorithmKey, byte[] key, byte[] ivp, byte[] data){

        SecretKey secretKey = new SecretKeySpec(key, algorithm);
        byte[] encrypt = null;
        try {
            Cipher cipher = Cipher.getInstance(algorithmKey);
            if (ivp==null) {
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            }else {
                cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(ivp));
            }
            encrypt = cipher.doFinal(data);
        } catch (Exception e) {
            log.error("{} encrypt error ", algorithm, e);
        }

        return encrypt;
    }

    /**
     * decrypt
     * @param algorithm
     * @param algorithmKey
     * @param key
     * @param ivp
     * @param data
     * @return
     * @throws Exception
     */
    public  byte[] decrypt(String algorithm,String algorithmKey, byte[] key, byte[] ivp, byte[] data){

        SecretKey secretKey = new SecretKeySpec(key, algorithm);
        byte[] encrypt = null;

        try {
            Cipher cipher = Cipher.getInstance(algorithmKey);
            if (ivp==null) {
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
            }else {
                cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(ivp));
            }
            encrypt = cipher.doFinal(data);
        } catch (Exception e) {
            log.error("{} decrypt error",algorithm,e);
        }

        return encrypt;
    }

    public  byte[] decrypt(String algorithm, RSAPrivateKey privateKey, byte[] data){

        byte[] cipherBytes = null;
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            cipherBytes = cipher.doFinal(data);
        } catch (Exception e) {
            log.error("{} encrypt error",algorithm,e);
        }
        return cipherBytes;
    }

    public  byte[] encrypt(String algorithm, PublicKey publicKey, byte[] data){

        byte[] cipherBytes = null;
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            cipherBytes = cipher.doFinal(data);
        } catch (Exception e) {
            log.error("{} encrypt error",algorithm,e);
        }
        return cipherBytes;
    }


}

