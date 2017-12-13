package org.laidu.crawler.helper.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.laidu.commom.util.xml.JAXBUtil;

import javax.xml.bind.JAXBException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;

class RootRequestTest {

    private RootRequest rootRequest;


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
                .responseSource("demo")
                .attentionField("demo")
                .attentionFieldValue("demo")
                .responseType("demo")
                .build();

        EncryptionFiled filed = EncryptionFiled.builder()
                .encryptionAlgorithm("MD5")
                .encryptionFiled("demo")
                .encryptionSource("dsaadassdas")
                .emcryptionExtendParams(EncryptionFiled.EmcryptionExtendParams.builder().emcryptionExtendParam(Collections.singletonList(EncryptionFiled.Extend.builder().name("demo").value("demo").build())).build())
                .build();


        CrawlerRequest request = CrawlerRequest.builder()
                .curl(curl)
                .encryptionFileds(CrawlerRequest.EncryptionFileds.builder().encryptionFiled(Collections.singletonList(filed)).build())
                .params(CrawlerRequest.Params.builder().param(Collections.singletonList(param)).build())
                .requestNameZh(requestNameZh)
                .responses(CrawlerRequest.Responses.builder().response(Collections.singletonList(response)).build())
                .build();

        rootRequest = RootRequest.builder()
                .request(Collections.singletonList(request))
                .build();


    }

    @Test
    void getRequest() throws JAXBException, UnsupportedEncodingException {

        System.out.println(JAXBUtil.getInstance().obj2Xml(rootRequest));

    }

    @Test
    void setRequest() {




    }

}