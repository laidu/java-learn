package org.laidu.learn.network.okhttp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.jetbrains.annotations.NotNull;

import com.google.common.collect.Maps;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * ok http client learn
 */
public class OkHttpDemo {

    public static void main(String[] args) throws IOException {

        Map<String, Cookie> cookieStore = Maps.newConcurrentMap();
        String mobile = "15010246761";

        CookieJar cookieJar = new CookieJar() {
            //这里可以做cookie传递，保存等操作
            @Override
            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {//可以做保存cookies操作
                System.out.println("cookies url: " + url.toString());
                cookieStore.putAll(cookies.stream()
                        .collect(Collectors.toMap(var ->
                                        String.format("%s_%s_%s", var.domain(), var.name(), var.path()), var -> var)));
            }

            @NotNull
            @Override
            public List<Cookie> loadForRequest(@NotNull HttpUrl url) {
                //加载新的cookies
                System.out.println("load cookies size : " + cookieStore.size());
                return new ArrayList<>(cookieStore.values());
            }
        };

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .cookieJar(cookieJar)
                .build();

        Request request = new Request.Builder()
                .url("https://login.10086.cn/needVerifyCode.htm?accountType=01&account=" + mobile + "&timestamp="+System.currentTimeMillis())
                .method("GET", null)
                .addHeader("Host", "login.10086.cn")
                .addHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:69.0) Gecko/20100101 Firefox/69.0")
                .addHeader("Accept", "application/json, text/javascript, */*; q=0.01")
                .addHeader("Accept-Language", "en-US,en;q=0.5")
                .addHeader("Accept-Encoding", "gzip, deflate")
                .addHeader("X-Requested-With", "XMLHttpRequest")
                .addHeader("DNT", "1")
                .addHeader("Connection", "close")
                .addHeader("Referer", "https://login.10086.cn/")
                .build();

        Response execute = client.newCall(request).execute();

        System.out.println(execute.body().string());


        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "userName=15010246761&loginMode=01&channelID=10000");
        Request request0 = new Request.Builder()
                .url("https://login.10086.cn/chkNumberAction.action")
                .method("POST", body)
                .addHeader("Host", "login.10086.cn")
                .addHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:69.0) Gecko/20100101 Firefox/69.0")
                .addHeader("Accept", "application/json, text/javascript, */*; q=0.01")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
                .addHeader("Accept-Encoding", "gzip, deflate")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("X-Requested-With", "XMLHttpRequest")
                .addHeader("DNT", "1")
                .addHeader("Connection", "close")
                .addHeader("Referer", "https://login.10086.cn/")
                .addHeader("Pragma", "no-cache")
                .addHeader("Cache-Control", "no-cache")
                .build();
        Response response = client.newCall(request0).execute();


        Request request1 = new Request.Builder()
                .url("https://login.10086.cn/sendflag.htm?timestamp="+ (System.currentTimeMillis()/1000))
                .method("GET", null)
                .addHeader("Host", "login.10086.cn")
                .addHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:69.0) Gecko/20100101 Firefox/69.0")
                .addHeader("Accept", "image/webp,*/*")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
                .addHeader("Accept-Encoding", "gzip, deflate")
                .addHeader("DNT", "1")
                .addHeader("Connection", "close")
                .addHeader("Referer", "https://login.10086.cn/")
                .build();
        Response response1 = client.newCall(request1).execute();


        Request request2 = new Request.Builder()
                .url("https://login.10086.cn/sendflag.htm?timestamp=1569689017")
                .method("GET", null)
                .addHeader("Host", "login.10086.cn")
                .addHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:69.0) Gecko/20100101 Firefox/69.0")
                .addHeader("Accept", "image/webp,*/*")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
                .addHeader("Accept-Encoding", "gzip, deflate")
                .addHeader("DNT", "1")
                .addHeader("Connection", "close")
                .addHeader("Referer", "https://login.10086.cn/")
                .build();
        Response response2 = client.newCall(request2).execute();

        MediaType mediaType3 = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body3 = RequestBody.create(mediaType, "userName=15010246761");
        Request request3 = new Request.Builder()
                .url("https://login.10086.cn/loadToken.action")
                .method("POST", body)
                .addHeader("Host", "login.10086.cn")
                .addHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:69.0) Gecko/20100101 Firefox/69.0")
                .addHeader("Accept", "application/json, text/javascript, */*; q=0.01")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
                .addHeader("Accept-Encoding", "gzip, deflate")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("X-Requested-With", "XMLHttpRequest")
                .addHeader("Content-Length", "20")
                .addHeader("DNT", "1")
                .addHeader("Connection", "close")
                .addHeader("Referer", "https://login.10086.cn/")
                .addHeader("Pragma", "no-cache")
                .addHeader("Cache-Control", "no-cache")
                .build();
        Response response3 = client.newCall(request3).execute();

        System.out.println(response3.body().string());

    }
}
