package org.laidu.commom.util.file;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件工具类
 * <p>
 * Created by laidu
 * on 2018-08-09 10:57.
 *
 * @author laidu
 */
@Slf4j
public enum FileUtil {
    // instance
    INSTANCE;

    public String getFileHead(File file) {

        String head = "未知文件";

        try (InputStream in = new FileInputStream(file)) {
            head = getFileHead(in);
        } catch (IOException e) {

            log.error("文件打开失败 : {}", file.getName(), e);
        }

        return head;
    }

    public String getFileHead(InputStream in) throws IOException {
        byte[] b = new byte[28];

        in.read(b, 0, 28);

        return bytesToHexString(b);
    }


    /**
     * 将文件头转换成16进制字符串
     *
     * @param src
     * @return
     */
    private String bytesToHexString(byte[] src) {

        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (byte aSrc : src) {
            int v = aSrc & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
}