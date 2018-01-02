package org.laidu.learn.language.feature.serialize;

import lombok.Data;

import java.io.ObjectStreamException;
import java.io.ObjectStreamField;
import java.io.Serializable;

/**
 * student
 *
 * @author tiancai.zang
 * 2018-01-02 10:45.
 */
// : 2018-01-02 10:45  student
@Data
public class Student implements Serializable{

    private static final long serialVersionUID = -3313075503108247550L;
    private static String flag = "STUDENT";

    private String name;

    transient private String className;
    public String gradeName;

    private static final ObjectStreamField[] serialPersistentFields = {
            new ObjectStreamField("name", String.class),
            new ObjectStreamField("className", String.class),
            new ObjectStreamField("gradeName", String.class),
    };

    private Object readResolve() throws ObjectStreamException {
        Student student = new Student();
        student.setName("read resolve");
        return student;
    }
}