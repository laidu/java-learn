package org.laidu.crawler.helper;

import com.alibaba.fastjson.JSON;
import jodd.io.FileUtil;
import jodd.util.StringUtil;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.laidu.commom.util.http.curl.CurlParserUtilV2;
import org.laidu.commom.util.xml.JAXBUtil;
import org.laidu.crawler.helper.model.CrawlerRequest;
import org.laidu.crawler.helper.model.RootRequest;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Map;

/**
 * page processor generator
 * <p>
 * Created by tiancai.zang on 2017-11-04 11:59.
 */
@Slf4j
public class PageProcessorGen {

    private static final String CODE_PATH = "/Users/tczang/IdeaProjects/temple/alpha-business/temple-business-crawler/temple-business-crawler-reg/src/main/java/com/alpha/business/crawler/app";
    private static final String CODE_PACKAGE = "com.alpha.business.crawler.app";
    private static final String TEMPLE_FILE = "com.alpha.business.crawler.app";
    private static final String XML_FILE = "com.alpha.business.crawler.app";

    public static void main(String[] args) throws IOException, JAXBException {

        /**
         * step 1、get all request objects
         */
        final String xmlContent = FileUtil.readString(PageProcessorGen.class.getClassLoader().getResource(XML_FILE).getFile());
        RootRequest rootRequest = JAXBUtil.getInstance().xml2Obj(xmlContent, RootRequest.class);


        rootRequest.getRequest().forEach(request -> {

            String template = null;

            try {
                template = FileUtil.readString(PageProcessorGen.class.getClassLoader().getResource(TEMPLE_FILE).getFile());
            } catch (IOException e) {
                log.error("{} file open error", TEMPLE_FILE, e);
            }

            if (StringUtil.isNotBlank(template)) {

                CurlParserUtilV2 curlParserUtilV2 = CurlParserUtilV2.init(request.getCurl());
                /**
                 * step 2、build all content
                 */

                String url = curlParserUtilV2.getUrl();
                String method = curlParserUtilV2.getMethod();

                /**
                 * step 2.1、build header string
                 */
                String header = buildHeaderString(curlParserUtilV2.getHeaders());
                /**
                 * step 2.2、build request params
                 */
                String requestParam = buildParamString(curlParserUtilV2.getFormBody());

                /**
                 * step 2.3、build sign method
                 */
                String signMethod = buildSignMethodString(request);

                /**
                 * step 2.4、build result parser logic
                 */

                /**
                 * step 3、repleace all build string and generator pageProcessor
                 */

            }
        });

    }

    private static String buildSignMethodString(@NonNull CrawlerRequest request) {
        StringBuilder signString = new StringBuilder();
        request.getEncryptionFileds().getEncryptionFiled().forEach(encryptionFiled -> {

            if (StringUtil.isNotBlank(encryptionFiled.getEncryptionAlgorithm())) {

            }else {
                log.error("encryption algorithm is blank : {}", JSON.toJSONString(encryptionFiled));
            }
        });
        return signString.toString();
    }


    private static String buildParamString(@NonNull Map<String, String> headers) {

        StringBuilder paramString = new StringBuilder();


        return paramString.toString();
    }
    
    private static String buildHeaderString(@NonNull Map<String, String> header) {
        StringBuilder headerString = new StringBuilder();
        header.forEach((key,value) -> headerString.append("\t\t\t.addHeader("+escapeString(key)+","+escapeString(value)+")\n"));
        return headerString.toString();
    }

    static String escapeString(@NonNull String originString) {
        if (originString.startsWith("\"")) {
            originString = originString.substring(1);
        }
        if (originString.endsWith("\"")) {
            originString = originString.substring(0, originString.length() - 1);
        }

        return "\"" + originString.replace("\\", "\\\\")
                .replace("\"", "\\\"") + "\"";
    }

}