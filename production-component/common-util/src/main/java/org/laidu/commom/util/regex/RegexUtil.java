package org.laidu.commom.util.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tczang
 */
public final class RegexUtil {

    /**
     * Private constructor.
     */
    private RegexUtil() {
    }

    /**
     * @return Singleton instance
     */
    public static RegexUtil getInstance() {
        return HelperHolder.INSTANCE;
    }

    /**
     * Provides the lazy-loaded Singleton instance.
     */
    private static class HelperHolder {
        private static final RegexUtil INSTANCE =
                new RegexUtil();
    }

    /**
     * get regex match string list
     *
     * @param regex  regex string
     * @param source source string
     * @param index  match () index
     * @return match result list
     */
    public List<String> getMacthAllResult(String regex, String source, int index) {

        List<String> result = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(source);

        while (matcher.find()) {
            result.add(matcher.group(index));
        }

        return result;
    }

    public List<String> getMacthAllResult(String regex, String source) {

        return getMacthAllResult(regex, source, 0);
    }

    public String getMacthResult(String regex, String source) {

        return getMacthResult(regex, source, 0);
    }

    public String getMacthResult(String regex, String source, int index) {

        return getMacthResult(regex,source,index,null);
    }

    public String getMacthResult(String regex, String source, int index, String defaultValue) {

        String result = defaultValue;

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(source);

        if ( matcher.find() ) {
            result = matcher.group(index);
        }

        return result;
    }
}

