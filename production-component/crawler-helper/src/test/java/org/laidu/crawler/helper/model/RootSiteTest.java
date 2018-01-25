package org.laidu.crawler.helper.model;

import jodd.io.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.laidu.commom.util.xml.JAXBUtil;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;

@Slf4j
class RootSiteTest {

    private RootSite rootRequest;


    @BeforeEach
    void setUp() {

        String curl = "demo";
        String requestNameZh = "demo";

        CrawlerRequestParam param = CrawlerRequestParam.builder()
                .name("demo")
                .value("demo")
                .build();

        CrawlerResponse response = CrawlerResponse.builder()
                .responseName("demo")
                .contentSource("demo")
                .filedPath("demo")
                .filedValue("demo")
                .build();

        Encryption filed = Encryption.builder()
                .encryptionAlgorithm("MD5")
                .encryptionFiled("demo")
                .encryptionSource("dsaadassdas")
                .encryptionExtendParams(Encryption.EncryptionExtendParams.builder().encryptionExtendParam(Collections.singletonList(Encryption.Extend.builder().name("demo").value("demo").build())).build())
                .build();


        CrawlerSite request = CrawlerSite.builder()
                .curl(curl)
                .encryptions(CrawlerSite.Encryptions.builder().encryption(Collections.singletonList(filed)).build())
                .params(CrawlerSite.Params.builder().param(Collections.singletonList(param)).build())
                .siteNameZh(requestNameZh)
                .responses(CrawlerSite.Response.builder().response(Collections.singletonList(response)).build())
                .build();

        rootRequest = RootSite.builder()
                .site(Collections.singletonList(request))
                .build();


    }

    @Test
    void getRequest() throws JAXBException, IOException {

        String xml = FileUtil.readString(this.getClass().getClassLoader().getResource("xml/crawler-request-example.xml").getFile());

        RootSite request = JAXBUtil.getInstance().xml2Obj(xml,RootSite.class);

        log.info("xml 's value : {}", xml);
    }

    @Test
    void buildRequest() throws JAXBException, UnsupportedEncodingException {
        System.out.println(JAXBUtil.getInstance().obj2Xml(rootRequest));
    }

}