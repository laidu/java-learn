package org.laidu.commom.util.xml;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

class JAXBUtilTest {
    @Test
    void obj2Xml() throws JAXBException, UnsupportedEncodingException {

        List<String> names = new ArrayList<>();

        names.add("123");
        names.add("123");
        names.add("123");
        names.add("123");

        Person person = Person.builder()
                .name("xiaoming/name>aadsadsa]")
                .dsaa(names)
                .sex("nam")
                .build();

        List<Person> people = new ArrayList<>();

        people.add(person);
        people.add(person);
        people.add(person);
        people.add(person);

        String result  = JAXBUtil.getInstance().obj2Xml(Person1.builder().person(people).build());

        System.out.println(result);

    }

    @Test
    void xml2Obj() throws JAXBException {

        String xmlSource = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<persons>\n" +
                "    <person>\n" +
                "        <dsaa>123</dsaa>\n" +
                "        <dsaa>123</dsaa>\n" +
                "        <dsaa>123</dsaa>\n" +
                "        <dsaa>123</dsaa>\n" +
                "        <name>xiaoming/name&gt;aadsadsa]</name>\n" +
                "        <sex>nam</sex>\n" +
                "    </person>\n" +
                "    <person>\n" +
                "        <dsaa>123</dsaa>\n" +
                "        <dsaa>123</dsaa>\n" +
                "        <dsaa>123</dsaa>\n" +
                "        <dsaa>123</dsaa>\n" +
                "        <name>xiaoming/name&gt;aadsadsa]</name>\n" +
                "        <sex>nam</sex>\n" +
                "    </person>\n" +
                "    <person>\n" +
                "        <dsaa>123</dsaa>\n" +
                "        <dsaa>123</dsaa>\n" +
                "        <dsaa>123</dsaa>\n" +
                "        <dsaa>123</dsaa>\n" +
                "        <name>xiaoming/name&gt;aadsadsa]</name>\n" +
                "        <sex>nam</sex>\n" +
                "    </person>\n" +
                "    <person>\n" +
                "        <dsaa>123</dsaa>\n" +
                "        <dsaa>123</dsaa>\n" +
                "        <dsaa>123</dsaa>\n" +
                "        <dsaa>123</dsaa>\n" +
                "        <name>xiaoming/name&gt;aadsadsa]</name>\n" +
                "        <sex>nam</sex>\n" +
                "    </person>\n" +
                "</persons>";

        Person1 person1 = JAXBUtil.getInstance().xml2Obj(xmlSource,Person1.class);

        System.out.println();
    }


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Person{
        private String name;
        private String sex;


        private List<String> dsaa;

    }

    @Data
    @XmlRootElement(name = "persons")
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Person1{
        private List<Person> person;
    }


}