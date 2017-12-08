package org.laidu.learn.algorithm.encryption;

import jodd.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * DES算法实现
 * @author xzb
 *
 */
public class DESUtil {

	/**
	 * 生成密钥
	 * @throws Exception 
	 */
	public static byte[] initKey() throws Exception{
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
	public static byte[] encryptDES(byte[] data, byte[] key) throws Exception{
		//获得密钥
		SecretKey secretKey = new SecretKeySpec(key, "DES");
		//Cipher完成加密
		Cipher cipher = Cipher.getInstance("DES");
		//初始化cipher
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		//加密
		byte[] encrypt = cipher.doFinal(data);
		
		return encrypt;
	}
	
	/**
	 * 解密
	 */
	public static byte[] decryptDES(byte[] data, byte[] key) throws Exception{
		//恢复密钥
		SecretKey secretKey = new SecretKeySpec(key, "DES");
		//Cipher完成解密
		Cipher cipher = Cipher.getInstance("DES");
		//初始化cipher
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		//解密
		byte[] plain = cipher.doFinal(data);
		
		return plain;
	}

	public static void main(String[] args) throws Exception {

		System.out.println(Base64.encodeToString(encryptDES("{\"deviceImsi\":\"\",\"deviceUuid\":\"\",\"imei\":\"\",\"ip\":\"\",\"latitude\":\"\",\"loginId\":\"13241487379\",\"longitude\":\"\",\"mac\":\"\",\"password\":\"q1111111\",\"tokenKey\":\"97317bee-4a6b-4063-92ec-c908b47ffe96\"}".getBytes(),
				"ab_sdgd_".getBytes())));


		System.out.println(new String(decryptDES(Base64.decode("BQr0VsH+iN+VZMVameIzweZEH84tKfUxcWyYwMqFi2RI1iVKQLjNCKiW4G4zDoClCJSbUZuhkNeqGfEs5pI6/ywhukFgkT3lPOM4q+LbMwG7wlkKrRCNsJGJkUWrV2M6NmZjSKwy72wo1hXThNCpsfCby53VqI3b/JTAfzcsMwPl/u0vGXKdkQh7h25eH5+v1nrjCS4DGipsQI2blkKI55PBgQ2fsfgB"),
				"ab_sdgd_".getBytes())));

	}
}
