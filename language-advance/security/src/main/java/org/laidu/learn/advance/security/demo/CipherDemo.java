package org.laidu.learn.advance.security.demo;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

/**
 * cipher 使用
 *
 * @author tiancai.zang
 * on 2018-11-20 13:44.
 */
@Slf4j
public class CipherDemo {

    public static void main(String[] args) throws Exception {

        Security.addProvider(new BouncyCastleProvider());

        Cipher cipher = Cipher.getInstance("RSA/NONE/OAEPWithSHA1AndMGF1Padding","BC");
        cipher.init(Cipher.PUBLIC_KEY, new SecretKeySpec("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA".getBytes("UTF-8"), "AES"));

        byte[] bytes = cipher.doFinal("nihao".getBytes());


    }
}