package org.laidu.commom.util.encryption;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * md5 util
 * <p>
 * Created by tiancai.zang on 2017-12-15 14:05.
 */
@Slf4j
// : 2017/12/15 14/05 md5 util
public final class MD5Util {

    /**
     * Private constructor.
     */
    private MD5Util() {
    }

    /**
     * @return Singleton instance
     */
    public static MD5Util getInstance() {
        return HelperHolder.INSTANCE;
    }

    /**
     * Provides the lazy-loaded Singleton instance.
     */
    private static class HelperHolder {
        private static final MD5Util INSTANCE =
                new MD5Util();
    }


    public String toMd5(String origin){
        String re_md5 = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(origin.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }

            re_md5 = buf.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return re_md5;
    }
}

