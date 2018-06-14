package org.laidu.commom.util.xml;

import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

/**
 * JAXB util
 * <p>
 * Created by tiancai.zang on 2017-12-13 11:41.
 */
@Slf4j
// : 2017/12/13 11/41 JAXB util
public final class JAXBUtil {

    /**
     * Private constructor.
     */
    private JAXBUtil() {
    }

    /**
     * @return Singleton instance
     */
    public static JAXBUtil getInstance() {
        return HelperHolder.INSTANCE;
    }

    /**
     * Provides the lazy-loaded Singleton instance.
     */
    private static class HelperHolder {
        private static final JAXBUtil INSTANCE =
                new JAXBUtil();
    }

    public String obj2Xml(Object obj) throws JAXBException, UnsupportedEncodingException {

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true );
        jaxbMarshaller.marshal(obj,os);

        return new String(os.toByteArray(),"UTF-8");
    }

    public <T> T xml2Obj(String xmlSource, Class<T> clazz) throws JAXBException {

        JAXBContext context;
        context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshal = context.createUnmarshaller();
        T obj = (T) unmarshal.unmarshal(new StringReader(xmlSource));
        return obj;
    }


}

