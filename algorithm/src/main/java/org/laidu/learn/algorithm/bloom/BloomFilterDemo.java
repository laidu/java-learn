package org.laidu.learn.algorithm.bloom;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import jodd.io.FileUtil;
import org.laidu.commom.util.encryption.MD5Util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * bloom filter demo
 * 生成所有手机号并根据其md5 前三位作为文件名保存
 * @author tiancai.zang
 * 2018-02-01 15:09.
 */
// TODO: 2018-02-01 15:09   bloom filter demo
public class BloomFilterDemo {

    private static final long size = 1000_000_000;

    public static void main(String[] args) {

        int[] p = {3, 5, 7, 4, 8, 9};
//        BloomFilter<String> filter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")), size + size / 5, 0.0000001d);

        for (int var : p) {
            int num = var * 1000_000_000;
            for (long i = 0; i < size; i++) {
                doWork("1" + (num + i));
            }
        }

    }

    private static void doWork(String phone) {
        String md5;
        md5 = MD5Util.getInstance().toMd5(phone).substring(8, 24);
        try {
            FileUtil.appendString(new File(md5.substring(0,3)),phone+"-->"+md5+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        if (filter.mightContain(md5)) {
//            System.out.println(String.format("conflict ： %s", phone));
//        } else {
//            filter.put(md5);
//        }
    }
}