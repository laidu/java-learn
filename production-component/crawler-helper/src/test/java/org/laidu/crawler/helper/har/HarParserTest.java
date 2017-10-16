package org.laidu.crawler.helper.har;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.laidu.crawler.helper.HarHelper;
import org.laidu.crawler.helper.har.model.Har;
import org.laidu.crawler.helper.model.RequestInfo;

import java.util.List;

@Slf4j
class HarParserTest {

    private String harPath;

    @BeforeEach
    void setUp() {

        harPath = "har/www.189.cn.har";
    }

    @Test
    void parseHar() {



        Har har = new HarParser().parseHar(harPath);



    }

    @Test
    void getRequestTrack(){

        String targetUrl = "http://iservice.10010.com/e3/static/query/newQueryLeavePackageData?_=1508145044189&accessURL=http://iservice.10010.com/e4/skip.html?menuCode=000100040001&menuCode=000100040001";

        List<RequestInfo> requestInfoList =   HarHelper.parserRequestTrack(harPath,targetUrl);

        log.info("");


    }

}