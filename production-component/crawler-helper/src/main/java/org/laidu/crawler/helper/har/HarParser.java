package org.laidu.crawler.helper.har;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.laidu.crawler.helper.har.model.Har;

import java.io.File;
import java.io.IOException;

/**
 * parser
 * <p>
 * Created by tiancai.zang on 2017-10-12 16:35.
 */
@Slf4j
public class HarParser {

    /**
     * A HAR file is REQUIRED to be saved in UTF-8 encoding. Other encodings are forbidden.
     */
    public final static String DEFAULT_CHARSET = "utf-8";

    public static Har parseHar(final String harFileName){
        return parseHar(harFileName,DEFAULT_CHARSET);
    }

    private static Har parseHar(final String harFileName, final String charset) {

        Har result = Har.builder().build();

        File harFile = new File(HarParser.class.getClassLoader().getResource(harFileName).getFile());
        String harString = null;

        if (harFile.exists()) {
            try {
                harString = FileUtils.readFileToString(harFile, charset);
            } catch (IOException e) {
                log.error("har file [{}] open error ; {}", harFileName, e);
                return result;
            }
        }

        result = JSON.parseObject(harString, Har.class);
        return result;
    }
}