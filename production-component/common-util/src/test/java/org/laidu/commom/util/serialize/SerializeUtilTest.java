package org.laidu.commom.util.serialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class SerializeUtilTest {

    @Test
    void toByteArray() {

        // pojo
        Date date = new Date();
        byte[] bytes = SerializeUtil.INSTANCE.toByteArray(date);
        Date date1 = SerializeUtil.INSTANCE.toObject(bytes);
        assertEquals(date,date1);

        // deep serialize
        Student student = Student.builder()
                .name("jack")
                .classNo("123123")
                .classInfo(ClassInfo.builder()
                        .className("class1")
                        .classAdress("building1")
                        .build())
                .build();

    }

    @Test
    void toObject() {
    }

    @Test
    void toJSONString() {
    }


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    static class Student implements Serializable {
        private String name;
        private String classNo;
        private ClassInfo classInfo;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    static class ClassInfo implements Serializable{
        private String className;
        private String classAdress;
    }

}
