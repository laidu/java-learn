package org.laidu.commom.util.serialize;

import lombok.extern.slf4j.Slf4j;
import org.nustaq.serialization.FSTConfiguration;

/**
 * serialize util
 * <p>
 * Created by tiancai.zang
 * on 2018-05-10 12:46.
 * @author laidu
 */
@Slf4j
public enum SerializeUtil {
    // instance
    INSTANCE;

    private final FSTConfiguration defaultSerializer = FSTConfiguration.createDefaultConfiguration();

    /**
     * read one object to ByteArray
     *
     * @param object
     * @return
     */
    public byte[] toByteArray(Object object) {
        return defaultSerializer.asByteArray(object);
    }

    /**
     * get object from byte array
     * @param bytes
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T toObject(byte[] bytes){
        T o = null;
        try {
            o = (T) defaultSerializer.asObject(bytes);
        }catch (Exception e){
            log.error("反序列化错误");
        }
        return o;
    }

}