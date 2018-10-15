package org.laidu.commom.util.xml;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

/**
 * Jsoup xml parser
 * <p>
 * Created by tiancai.zang on 2017-12-13 10:51.
 */
@Slf4j
public final class JsoupParser {

    /**
     * Private constructor.
     */
    private JsoupParser() {
    }

    /**
     * @return Singleton instance
     */
    public static JsoupParser getInstance() {
        return HelperHolder.INSTANCE;
    }

    /**
     * Provides the lazy-loaded Singleton instance.
     */
    private static class HelperHolder {
        private static final JsoupParser INSTANCE =
                new JsoupParser();
    }


    public List<String> getStringNodes(String xmlSource,String nodePath){

        List<String> result = Collections.emptyList();

        return result;
    }


}

