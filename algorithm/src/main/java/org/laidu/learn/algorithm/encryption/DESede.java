package org.laidu.learn.algorithm.encryption;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;

/**
 * user: wen.chen(wen.chen@cafintech.com)
 * <p>
 * time: 17/12/5
 */
public class DESede {
    /**
     * 密钥算法
     * */
    public static final String KEY_ALGORITHM="DESede";

    /**
     * 加密/解密算法/工作模式/填充方式
     * */
    public static final String CIPHER_ALGORITHM="DESede/CBC/PKCS5Padding";

    /**
     *
     * 生成密钥
     * @return byte[] 二进制密钥
     * */
    public static byte[] initkey() throws Exception{

        //实例化密钥生成器
        KeyGenerator kg=KeyGenerator.getInstance(KEY_ALGORITHM);
        //初始化密钥生成器
        kg.init(168);
        //生成密钥
        SecretKey secretKey=kg.generateKey();
        //获取二进制密钥编码形式
        return secretKey.getEncoded();
    }
    /**
     * 转换密钥
     * @param key 二进制密钥
     * @return Key 密钥
     * */
    public static Key toKey(byte[] key) throws Exception{
        //实例化Des密钥
        DESedeKeySpec dks=new DESedeKeySpec(key);
        //实例化密钥工厂
        SecretKeyFactory keyFactory=SecretKeyFactory.getInstance(KEY_ALGORITHM);
        //生成密钥
        SecretKey secretKey=keyFactory.generateSecret(dks);
        return secretKey;
    }

    /**
     * 加密数据
     * @param data 待加密数据
     * @param key 密钥
     * @return byte[] 加密后的数据
     * */
    public static byte[] encrypt(byte[] data,byte[] key,byte[] ivp) throws Exception{
        //还原密钥
        Key k=toKey(key);
        //实例化
        Cipher cipher=Cipher.getInstance(CIPHER_ALGORITHM);
        //初始化，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, k,new IvParameterSpec(ivp));
        //执行操作
        return cipher.doFinal(data);
    }
    /**
     * 解密数据
     * @param data 待解密数据
     * @param key 密钥
     * @return byte[] 解密后的数据
     * */
    public static byte[] decrypt(byte[] data,byte[] key,byte[] ivp) throws Exception{
        //欢迎密钥
        Key k =toKey(key);
        //实例化
        Cipher cipher=Cipher.getInstance(CIPHER_ALGORITHM);
        //初始化，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, k, new IvParameterSpec(ivp));
        //执行操作
        return cipher.doFinal(data);
    }
    /**
     * 进行加解密的测试
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
//        String str="DESede";
//        System.out.println("原文：/t"+str);
//        //初始化密钥
//        byte[] key=DESede.initkey();
//        System.out.println("密钥：/t"+ Base64.encodeBase64String(key));
//        //加密数据
//        byte[] data=DESede.encrypt(str.getBytes(), key);
//        System.out.println("加密后：/t"+Base64.encodeBase64String(data));
//        //解密数据
//        data=DESede.cbcDecrypt(data, key);
//        System.out.println("解密后：/t"+new String(data));


//        System.out.println(new String(cbcDecrypt(Hex.decodeHex("b5720f816f50db5eb94116fd795b9f770f4af1f252692aa8c138f0e8150856db0b52b7c8000a7be699aabc4ab106f380f9e488a10e8269792beb5b46a667cdf32e20cf7649e74841dcfc49d871e100bda5b005efdca1abf6d8f95b802b6db01dc0bc44d9f75be7b899fcac6bf3674bff51429cb76f9ea218fa2bad0b88a6c6c80d9edbb96f284e26c08a514ffe89869973b1d297873df3042f7fed5cff21498279cee5c1521deab082083b21bbdbcdcbe94fb492867d0f86e85abe28a833f518ae8bea426903c923bd5014d733aca51d689036c848d6a9f9a984ac4b07ea513bc0e43baa0023274cbac722d157661202e3f3be1793e6e813".toCharArray()),
//                "1234567`90koiuyhgtfrdews".getBytes(),Hex.decodeHex("0000000000000000".toCharArray()))));


    }
}
