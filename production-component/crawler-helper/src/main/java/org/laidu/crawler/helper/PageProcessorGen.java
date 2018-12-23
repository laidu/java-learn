package org.laidu.crawler.helper;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.MethodSpec;
import jodd.io.FileUtil;
import jodd.util.StringUtil;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.laidu.commom.util.http.curl.CurlParserUtilV2;
import org.laidu.commom.util.xml.JAXBUtil;
import org.laidu.crawler.helper.model.CrawlerSite;
import org.laidu.crawler.helper.model.Encryption;
import org.laidu.crawler.helper.model.RootSite;

import javax.lang.model.element.Modifier;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * page processor generator
 * <p>
 * Created by tiancai.zang on 2017-11-04 11:59.
 */
@Slf4j
public class PageProcessorGen {

    private static final String PROJECT_PATH = "/Users/tczang/IdeaProjects/java-learn/";
    private static final String CODE_PATH = PROJECT_PATH + "production-component/crawler-helper/src/main/resources/template/";
    private static final String CODE_PACKAGE = "com.alpha.business.crawler.app";
    private static final String TEMPLE_FILE = "template/PageProcessorTemplate.java";
    private static final String XML_FILE = "curl/curl-demo.xml";

    public static void main(String[] args) throws IOException, JAXBException {

        /**
         * step 1、get all request objects
         */
        final String xmlContent = FileUtil.readString(PageProcessorGen.class.getClassLoader().getResource(XML_FILE).getFile());
        RootSite rootRequest = JAXBUtil.getInstance().xml2Obj(xmlContent, RootSite.class);


        rootRequest.getSite().forEach(request -> {

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
                String signMethod = buildAllSignMethodString(request);

                /**
                 * step 2.4、build result parser logic
                 */

                /**
                 * step 3、repleace all build string and generator pageProcessor
                 */


            }
        });

    }

    private static String buildAllSignMethodString(@NonNull CrawlerSite request) {
        StringBuilder signString = new StringBuilder();
        List<String> signMethodList = new ArrayList<>();

        request.getEncryptions().getEncryption().forEach(encryption -> signMethodList.add(buildSignMethodString(encryption)));
        return signString.toString();
    }

    private static String buildSignMethodString(@NonNull Encryption encryption) {

        StringBuilder signMethod = new StringBuilder();

        if (StringUtil.isNotBlank(encryption.getEncryptionFiled())) {

            MethodSpec method = MethodSpec.methodBuilder(encryption.getEncryptionFiled())
                    .addModifiers(Modifier.PRIVATE)
                    .addParameter(String.class,"origin")
                    .addJavadoc(new Gson().toJson(encryption) + "\n")
                    .addCode(CodeBlock.builder().add("// TODO : "+ encryption.getEncryptionFiled()).add("return \"\";\\n ").build())
                    .returns(String.class)
                    .build();

            signMethod.append("\n"+ method.toString());

        }else {
            log.error("encryption algorithm is blank : {}", JSON.toJSONString(encryption));
        }

        return signMethod.toString();
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