package org.laidu.learn.advance.security.demo;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.RSAPublicKeySpec;

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
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        Cipher cipher = Cipher.getInstance("RSA/NONE/OAEPWithSHA1AndMGF1Padding");

        RSAPublicKeySpec publicKeySpec = new RSAPublicKeySpec(new BigInteger("65537"), new BigInteger("106882600647480514425203993707237979118872422951401375908983282906487692723410215442759547605803056576906218497184092858227835965536513358181249995214218936822735364017932094056653315972781647444937415684970985863266111417822863732480922077774932449773468399591710215272309257361400091066747899303034932341649"));

        PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);

        byte[] bytes = cipher.doFinal("n".getBytes());


    }
}