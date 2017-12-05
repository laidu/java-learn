import lombok.extern.slf4j.Slf4j;
import model.Person;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;

/**
 * test
 * <p>
 * Created by tiancai.zang on 2017-12-05 10:19.
 */
@Slf4j
public class Test {

    public static void test1(Person person) throws CloneNotSupportedException {

        for (int i=0;i<200;i++){

            Person person1 = (Person) person.clone();
        }
    }

    public static void test2(Person person){

        byte[] bytes = serialize(person);

        for (int i=0;i<200;i++){

            Person person1 = (Person) deserialize(bytes);
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        long date1 = System.currentTimeMillis();

        Person p = Person.builder()
                .endTime(System.currentTimeMillis())
                .extras(new Properties())
                .retryTimes(new AtomicLong(11))
                .startTime(System.currentTimeMillis())
                .queryCode(" sdaajda")
                .timeout(5000)
                .build();

        test1(p);

        System.out.println("test1 time :"+(System.currentTimeMillis() - date1));

        date1 = System.currentTimeMillis();

        test2(p);

        System.out.println("test2 time :"+(System.currentTimeMillis() - date1));

    }
    /**
     * Serialize the object provided.
     *
     * @param object the object to serialize
     * @return an array of bytes representing the object in a portable fashion
     */
    public static byte[] serialize(Object object) {
        if (object == null) {
            return null;
        }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(stream).writeObject(object);
        }
        catch (IOException e) {
            throw new IllegalArgumentException("Could not serialize object of type: " + object.getClass(), e);
        }
        return stream.toByteArray();
    }

    /**
     * @param bytes a serialized object created
     * @return the result of deserializing the bytes
     */
    public static Object deserialize(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        try {
            return deserialize(new ObjectInputStream(new ByteArrayInputStream(bytes)));
        }
        catch (IOException e) {
            throw new IllegalArgumentException("Could not deserialize object", e);
        }
    }

    /**
     * @param stream an object stream created from a serialized object
     * @return the result of deserializing the bytes
     */
    public static Object deserialize(ObjectInputStream stream) {
        if (stream == null) {
            return null;
        }
        try {
            return stream.readObject();
        }
        catch (IOException e) {
            throw new IllegalArgumentException("Could not deserialize object", e);
        }
        catch (ClassNotFoundException e) {
            throw new IllegalStateException("Could not deserialize object type", e);
        }
    }
}