package org.laidu.commom.util.enums;

/**
 * common entryption algorithm
 * <p>
 * algorithm/mode/padding
 * Created by tiancai.zang on 2017-12-15 10-05.
 */
// TODO: 2017/12/15 10/05 common entryption algorithm
public enum EntryptionAlgoithmEnum {

    ;

    public enum Algorithm{
        AES,
        DES,
        DESede,
        RSA,
        SHA
        ;
    }

    public enum Mode{
        ECB,
        CBC,
        CTR,
        OFB,
        CFB,
        ;
    }

    public enum Padding{
        PKCS5Padding,
        PKCS7Padding,
        ZEROPadding,
        ISO10126,
        ANSIX923,
        ;
    }
}