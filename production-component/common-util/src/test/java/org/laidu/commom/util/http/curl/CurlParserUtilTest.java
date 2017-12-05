package org.laidu.commom.util.http.curl;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CurlParserUtilTest {

    private String curlLine;

    @BeforeEach
    void setUp() {

//        curlLine = "curl -i -s -k  -X $'GET' \\\n" +
//                "    -H $'Upgrade-Insecure-Requests: 1' -H $'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36' -H $'Referer: https://www.google.com.sg/' \\\n" +
//                "    -b $'uuid_tt_dd=1449951587432284316_20171009; bdshare_firstime=1507526697430; _JQCMT_ifcookie=1; _JQCMT_browser=9b9bfcf50ae6c14645788efed25613f9; UN=weixin_38032099; UE=\\\"\\\"; BT=1509089267060; ADHOC_MEMBERSHIP_CLIENT_ID1.0=f4889c67-3d52-6eb3-6cb4-e7a329d9b3c5; Hm_ct_6bcd52f51e9b3dce32bec4a3997715ac=1788*1*PC_VC; __utma=17226283.2019445080.1508118317.1508118317.1512040235.2; __utmz=17226283.1512040235.2.2.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); uuid=f46ae314-3c9c-41e4-89a8-be900dd703ed; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1512105168,1512105684,1512108075,1512109410; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1512109410; dc_tos=p09r36; dc_session_id=1512108074250' \\\n" +
//                "    $'http://blog.csdn.net/asc2046/article/details/71352843'";


//        curlLine = "curl -i -s -k  -X $'GET' \\\n" +
//                "    -H $'Upgrade-Insecure-Requests: 1' -H $'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36' -H $'Referer: https://www.google.com.sg/' \\\n" +
//                "    -b $'uuid_tt_dd=1449951587432284316_20171009; bdshare_firstime=1507526697430; _JQCMT_ifcookie=1; _JQCMT_browser=9b9bfcf50ae6c14645788efed25613f9; UN=weixin_38032099; UE=\\\"\\\"; BT=1509089267060; ADHOC_MEMBERSHIP_CLIENT_ID1.0=f4889c67-3d52-6eb3-6cb4-e7a329d9b3c5; Hm_ct_6bcd52f51e9b3dce32bec4a3997715ac=1788*1*PC_VC; __utma=17226283.2019445080.1508118317.1508118317.1512040235.2; __utmz=17226283.1512040235.2.2.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); uuid=f46ae314-3c9c-41e4-89a8-be900dd703ed; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1512105168,1512105684,1512108075,1512109410; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1512109410; dc_tos=p09r36; dc_session_id=1512108074250' \\\n" +
//                "    $'http://blog.csdn.net/asc2046/article/details/71352843'";

//        curlLine = "curl -i -s -k  -X $'POST' \\\n" +
//                "    -H $'Content-Type: application/json; charset=utf-8' -H $'User-Agent: okhttp/3.8.1' \\\n" +
//                "    --data-binary $'jlX3dWILl/dMQ+wc0JAMHlKhylfeLb19HyBcb/QKcPKRMtB5Ri77QJ2OpC6P8Rp/aai3j7awGyo1SD/MckKxnHTeGnUIh9Uopg7S+4Db1n8hVV9vsQMLrmZy+0VCnGFgVuTWYvMgiow9+tZJFFdQ549IhLmXBs4Lm3UkEtzpfvwfdoCZC9vAaTbvc6YrGFk9vTRUag3oT+Wlm+RY8KaejV7JXCzV4+jA98GFbVTAn4yNuPIyIoHyhoELsnvMwlbuVmftKn0DDlVWM7xt7P9+AMiyXbNu+2xMuW6w+1EK//xbk337RCYjknh5AZpOKlCblRQpC1S4g1EroFZ1jWKCsA=123' \\\n" +
//                "    $'http://api.youqianla.cc/dt/login'";
        curlLine = "curl -i -s -k  -X $'POST' \\\n" +
                "    -H $'Content-Type: application/x-www-form-urlencoded' -H $'User-Agent: okhttp/3.4.1' \\\n" +
                "    --data-binary $'request_time=1512353107&app_key=dc3c7ac6&password=cdd450b159f7a171dafad54d158c4688&sign=d8f9d73445d919171d29066955f5d126&sign_version=1.1&imei=869055023868155&phone_key=phone_key&phone=1563848070' \\\n" +
                "    $'http://ddsiren.ddkuaiqian.com/v1/user/login?sign=%2FmanV8ivq0vgq%2FICSmy7%2Fg0W55xb9%2FfkeIf7IG8oy3obu9rm536xn7gb%2BIDvycvr&md5=ecad96a93d1bb48a527a59b2c6e42367&&platform=android&osv=6.0.1&appv=1.0.0.2.4&macid=02%3A00%3A00%3A00%3A00%3A00&ostype=Android6.0.1&udid=700103b52d693a9&m=Redmi+3&net=WIFI&app=dd&os=android'";
    }

    @Test
    void getHeaders() {

        CurlParserUtil.getInstance().getHeaders(curlLine);
    }

    @Test
    void getCookies() {

        CurlParserUtil.getInstance().getCookies(curlLine).forEach((k,v) ->
                System.out.println(k + " : " + v));

    }

    @Test
    void getMethod() {
        Assert.assertEquals("POST",CurlParserUtil.getInstance().getMethod(curlLine));
    }

    @Test
    void getUrl() {
        Assert.assertEquals("http://api.youqianla.cc/dt/login",CurlParserUtil.getInstance().getUrl(curlLine));
    }

    @Test
    void getBodyString() {
        String dataString = "jlX3dWILl/dMQ+wc0JAMHlKhylfeLb19HyBcb/QKcPKRMtB5Ri77QJ2OpC6P8Rp/aai3j7awGyo1SD/MckKxnHTeGnUIh9Uopg7S+4Db1n8hVV9vsQMLrmZy+0VCnGFgVuTWYvMgiow9+tZJFFdQ549IhLmXBs4Lm3UkEtzpfvwfdoCZC9vAaTbvc6YrGFk9vTRUag3oT+Wlm+RY8KaejV7JXCzV4+jA98GFbVTAn4yNuPIyIoHyhoELsnvMwlbuVmftKn0DDlVWM7xt7P9+AMiyXbNu+2xMuW6w+1EK//xbk337RCYjknh5AZpOKlCblRQpC1S4g1EroFZ1jWKCsA=123";
        Assert.assertEquals(dataString,CurlParserUtil.getInstance().getBodyString(curlLine));
    }

    @Test
    void getFormBody() {

        CurlParserUtil.getInstance().getFormBody(curlLine).forEach((k,v) ->
                System.out.println(k + " : " + v));
    }
}