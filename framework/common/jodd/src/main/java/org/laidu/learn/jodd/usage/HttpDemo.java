package org.laidu.learn.jodd.usage;

import jodd.http.HttpBrowser;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import jodd.net.HttpMethod;
import lombok.extern.slf4j.Slf4j;

/**
 * httpdemo
 *
 * @author tiancai.zang
 * on 2018-08-28 17:45.
 */
// TODO: 2018-08-28 17:45  httpdemo
@Slf4j
public class HttpDemo {


    public static void main(String[] args) {

//        brower();

        HttpResponse response = HttpRequest.create(HttpMethod.GET.name(), "首页")
                .followRedirects(true)
                .accept("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                .acceptEncoding("gzip, deflate, br")
                .path("http://www.baidu.com/")
                .host("www.baidu.com")
                .header("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36")
                .header("Accept-Language", "zh-CN,zh;q=0.9").send();


    }

    private static void brower() {
        HttpBrowser browser = new HttpBrowser();


        HttpRequest request = HttpRequest.create(HttpMethod.GET.name(),"首页")
                .followRedirects(true)
                .accept("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                .acceptEncoding("gzip, deflate, br")
                .path("https://www.baidu.com/")
                .host("www.baidu.com")
                .header("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36")
                .header("Accept-Language","zh-CN,zh;q=0.9");

        browser.sendRequest(request);


        System.out.println(browser.getPage());
    }

}