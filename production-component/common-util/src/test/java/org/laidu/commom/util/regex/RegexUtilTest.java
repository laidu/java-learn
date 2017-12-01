package org.laidu.commom.util.regex;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class RegexUtilTest {

    private String source;

    @BeforeEach
    void setUp() {

        source = "curl -i -s -k  -X $'GET' \\\n" +
                "    -H $'Upgrade-Insecure-Requests: 1' -H $'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36' -H $'Referer: https://www.google.com.sg/' \\\n" +
                "    -b $'uuid_tt_dd=1449951587432284316_20171009; bdshare_firstime=1507526697430; _JQCMT_ifcookie=1; _JQCMT_browser=9b9bfcf50ae6c14645788efed25613f9; UN=weixin_38032099; UE=\\\"\\\"; BT=1509089267060; ADHOC_MEMBERSHIP_CLIENT_ID1.0=f4889c67-3d52-6eb3-6cb4-e7a329d9b3c5; Hm_ct_6bcd52f51e9b3dce32bec4a3997715ac=1788*1*PC_VC; __utma=17226283.2019445080.1508118317.1508118317.1512040235.2; __utmz=17226283.1512040235.2.2.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); uuid=f46ae314-3c9c-41e4-89a8-be900dd703ed; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1512105168,1512105684,1512108075,1512109410; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1512109410; dc_tos=p09r36; dc_session_id=1512108074250' \\\n" +
                "    $'http://blog.csdn.net/asc2046/article/details/71352843'";
    }

    @Test
    void getMacthAllResult() {
    }

    @Test
    void getMacthAllResult1() {

        source = "nulluuid_tt_dd=1449951587432284316_20171009; bdshare_firstime=1507526697430; _JQCMT_ifcookie=1; _JQCMT_browser=9b9bfcf50ae6c14645788efed25613f9; UN=weixin_38032099; UE=\\\"\\\"; BT=1509089267060; ADHOC_MEMBERSHIP_CLIENT_ID1.0=f4889c67-3d52-6eb3-6cb4-e7a329d9b3c5; Hm_ct_6bcd52f51e9b3dce32bec4a3997715ac=1788*1*PC_VC; __utma=17226283.2019445080.1508118317.1508118317.1512040235.2; __utmz=17226283.1512040235.2.2.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); uuid=f46ae314-3c9c-41e4-89a8-be900dd703ed; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1512105168,1512105684,1512108075,1512109410; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1512109410; dc_tos=p09r36; dc_session_id=1512108074250";

        List<String> resultList = RegexUtil.getInstance().getMacthAllResult("([^; ]*=[^;]*)+",source,1);

        resultList.forEach(System.out::println);
    }

    @Test
    void getMacthResult() {

        String exected = "uuid_tt_dd=1449951587432284316_20171009; bdshare_firstime=1507526697430; _JQCMT_ifcookie=1; _JQCMT_browser=9b9bfcf50ae6c14645788efed25613f9; UN=weixin_38032099; UE=\\\"\\\"; BT=1509089267060; ADHOC_MEMBERSHIP_CLIENT_ID1.0=f4889c67-3d52-6eb3-6cb4-e7a329d9b3c5; Hm_ct_6bcd52f51e9b3dce32bec4a3997715ac=1788*1*PC_VC; __utma=17226283.2019445080.1508118317.1508118317.1512040235.2; __utmz=17226283.1512040235.2.2.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); uuid=f46ae314-3c9c-41e4-89a8-be900dd703ed; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1512105168,1512105684,1512108075,1512109410; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1512109410; dc_tos=p09r36; dc_session_id=1512108074250";

        Assert.assertEquals(exected,RegexUtil.getInstance().getMacthResult("-b \\$'([^']*)'",source,1));
    }

    @Test
    void getMacthResult1() {
    }

}