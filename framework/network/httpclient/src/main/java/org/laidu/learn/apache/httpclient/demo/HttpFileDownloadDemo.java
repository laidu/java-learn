package org.laidu.learn.apache.httpclient.demo;

import jodd.io.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 使用 httpclient 进行文件下载
 * <p>
 * Created by tiancai.zang
 * on 2018-09-27 23:28.
 */
@Slf4j
public class HttpFileDownloadDemo {

    public static void main(String[] args) {

        String fileUrl = "https://mirrors.tuna.tsinghua.edu.cn/centos/7.5.1804/isos/x86_64/CentOS-7-x86_64-NetInstall-1804.iso";

        try(CloseableHttpClient httpclient = HttpClients.createDefault()) {

            HttpGet httpget = new HttpGet(fileUrl);

            System.out.println("Executing request " + httpget.getRequestLine());

            ResponseHandler<byte[]> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toByteArray(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };

            StopWatch started = StopWatch.createStarted();
//            started.start();
            byte[] bytes = httpclient.execute(httpget, responseHandler);
            started.stop();

            log.info("started.getTime(TimeUnit.MICROSECONDS)'s value : {}", started.getTime(TimeUnit.MICROSECONDS));
            File tempFile = FileUtil.createTempFile();
            FileUtil.writeBytes(tempFile,bytes);

            log.info("tempFile.getPath()'s value : {}", tempFile.getPath());


        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}