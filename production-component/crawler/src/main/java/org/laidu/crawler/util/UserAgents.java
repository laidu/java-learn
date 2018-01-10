package org.laidu.crawler.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UserAgents {
    private static Map<Integer, String> userAgents = new HashMap<>();
    static {
        //Chrome 39.0 Win7 64-bit
        userAgents.put(1, "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 " +
                "(KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36");
        //Firefox 34.0 Win7 64-bit
        userAgents.put(2, "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:34.0) Gecko/20100101 Firefox/34.0");
        //Chrome 39.0 MacOSX
        userAgents.put(3, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 " +
                "(KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36");
        //Safari 8.0 MacOSX
        userAgents.put(4, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/600.2.5 " +
                "(KHTML, like Gecko) Version/8.0.2 Safari/600.2.5");
        //Chrome 39.0 Win8.1 64-bit
        userAgents.put(5, "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) " +
                "Chrome/39.0.2171.95 Safari/537.36");
        //Chrome 39.0 Win7 64-bit
        userAgents.put(6, "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko)" +
                " Chrome/39.0.2171.71 Safari/537.36");
        //IE 11.0 Win7 64-bit
        userAgents.put(7, "Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko");
        //Chrome 39.0 MacOSX
        userAgents.put(8, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_5) AppleWebKit/537.36 " +
                "(KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36");
        //Firefox 34.0 Win8.1 64-bit
        userAgents.put(9, "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:34.0) Gecko/20100101 Firefox/34.0");
        //Mobile Safari 8.0 iOS
//        userAgents.put(10, "Mozilla/5.0 (iPhone; CPU iPhone OS 8_1_2 like Mac OS X) AppleWebKit/600.1.4 " +
//                "(KHTML, like Gecko) Version/8.0 Mobile/12B440 Safari/600.1.4");
        userAgents.put(10, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:34.0) Gecko/20100101 Firefox/34.0");
        //Firefox 34.0 MacOSX
        userAgents.put(11, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:34.0) Gecko/20100101 Firefox/34.0");
        //Safari 8.0 MacOSX
        userAgents.put(12, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/600.1.25 " +
                "(KHTML, like Gecko) Version/8.0 Safari/600.1.25");
        //Chrome 39.0 MacOSX
        userAgents.put(13, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 " +
                "(KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36");
        //Chrome 39.0 Win7 32-bit
        userAgents.put(14, "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) " +
                "Chrome/39.0.2171.95 Safari/537.36");
        //Chrome 39.0 Win8.1 64-bit
        userAgents.put(15, "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) " +
                "Chrome/39.0.2171.71 Safari/537.36");
        //Firefox 34.0 MacOSX
        userAgents.put(16, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:34.0) Gecko/20100101 Firefox/34.0");
        //Chrome 39.0 Linux
        userAgents.put(17, "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) " +
                "Chrome/39.0.2171.95 Safari/537.36");
        //Firefox 34.0 Win7 32-bit
        userAgents.put(18, "Mozilla/5.0 (Windows NT 6.1; rv:34.0) Gecko/20100101 Firefox/34.0");
        //Firefox 34.0 Ubuntu
        userAgents.put(19, "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:34.0) Gecko/20100101 Firefox/34.0");
        //Chrome 39.0 MacOSX
        userAgents.put(20, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_5) AppleWebKit/537.36 " +
                "(KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36");
        //QuickLook MacOSX
        userAgents.put(21, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/600.1.25 " +
                "(KHTML, like Gecko) QuickLook/5.0");
        //Mobile Safari 8.0 iOS
        userAgents.put(22, "Mozilla/5.0 (iPad; CPU OS 8_1_2 like Mac OS X) AppleWebKit/600.1.4 " +
                "(KHTML, like Gecko) Version/8.0 Mobile/12B440 Safari/600.1.4");
        //Safari 7.1 MacOSX
        userAgents.put(23, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_5) AppleWebKit/600.1.17 (KHTML, like Gecko) " +
                "Version/7.1 Safari/537.85.10");
        //Firefox 33.0 Win7 64-bit
        userAgents.put(24, "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:33.0) Gecko/20100101 Firefox/33.0");
        //Safari 7.1 MacOSX
        userAgents.put(25, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_5) AppleWebKit/600.2.5 (KHTML, like Gecko) " +
                "Version/7.1.2 Safari/537.85.11");
        //Mobile Safari 7.0 iOS
        userAgents.put(26, "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:34.0) Gecko/20100101 Firefox/34.0");
//        userAgents.put(26, "Mozilla/5.0 (iPhone; CPU iPhone OS 7_1_2 like Mac OS X) AppleWebKit/537.51.2 " +
//                "(KHTML, like Gecko) Version/7.0 Mobile/11D257 Safari/9537.53");
        //
        userAgents.put(27, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_0) AppleWebKit/537.36 " +
                "(KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36");
        //Chrome 39.0 MacOSX
        userAgents.put(28, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_5) AppleWebKit/600.2.5 (KHTML, like Gecko) " +
                "Version/7.1.2 Safari/537.85.11");
        //IE 11.0 Win8.1 64-bit
        userAgents.put(29, "Mozilla/5.0 (Windows NT 6.3; WOW64; Trident/7.0; rv:11.0) like Gecko");
        //Chrome 39.0 WinXP 32-bit
        userAgents.put(30, "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) " +
                "Chrome/39.0.2171.95 Safari/537.36");
        userAgents.put(31, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36");
    }

    //如果请求参数在map中没有会返回一个默认值
    public static String getUserAgent(Integer key) {
        return userAgents.get(key) == null ? userAgents.get(1) : userAgents.get(key);
    }

    public static String getRandomUserAgent(){
        return userAgents.get(new Random().nextInt(30) + 1);
    }
}
