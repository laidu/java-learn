package org.laidu.learn.spring.mvc.conf;

import lombok.extern.slf4j.Slf4j;
import org.laidu.commom.util.enums.NameValueEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * UniversalEnumConverterFactory
 *
 * 实现enum 2 int 转换
 *
 * @author tiancai.zang
 * on 2018-08-23 12:40.
 */
@Slf4j
public class UniversalEnumConverterFactory implements ConverterFactory<String, NameValueEnum> {

    private static final Map<Class, Converter> CONVERTER_MAP = new WeakHashMap<>();

    @Override
    public <T extends NameValueEnum> Converter<String, T> getConverter(Class<T> targetType) {
        Converter result = CONVERTER_MAP.get(targetType);
        if(result == null) {
            result = new IntegerStrToEnum<T>(targetType);
            CONVERTER_MAP.put(targetType, result);
        }
        return result;
    }

    class IntegerStrToEnum<T extends NameValueEnum> implements Converter<String, T> {

        private final Class<T> enumType;
        private Map<String, T> enumMap = new HashMap<>();

        public IntegerStrToEnum(Class<T> enumType) {
            this.enumType = enumType;

            T[] enums = enumType.getEnumConstants();

            for(T e : enums) {
                enumMap.put(String.valueOf(e.getValue()), e);
            }
        }


        @Override
        public T convert(String source) {

            T result = enumMap.get(source);

            if(result == null) {
                throw new IllegalArgumentException("No element matches " + source);
            }
            return result;
        }
    }
}
