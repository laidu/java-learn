package org.laidu.commom.util.json;

/**
 * fastjson util
 *
 * @author tiancai.zang
 * 2017-12-27 10:22.
 */
public final class JsonUtil {

    /**
     * Private constructor.
     */
    private JsonUtil() {
    }

    /**
     * @return Singleton instance
     */
    public static JsonUtil getInstance() {
        return JsonUtilHolder.INSTANCE;
    }

    /**
     * Provides the lazy-loaded Singleton instance.
     */
    private static class JsonUtilHolder {

        private static final JsonUtil INSTANCE =
                new JsonUtil();
    }



}