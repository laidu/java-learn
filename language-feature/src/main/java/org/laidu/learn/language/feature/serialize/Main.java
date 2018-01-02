package org.laidu.learn.language.feature.serialize;

import java.io.*;

/**
 * main
 *
 * @author tiancai.zang
 * 2018-01-02 10:47.
 */
// TODO: 2018-01-02 10:47  main
public class Main {

    public static void main(String[] args) {

        System.gc();


        String path = "/Users/tczang/IdeaProjects/java-learn/language-feature/src/main/resources"+"/student.bin";
        try (OutputStream outputStream = new FileOutputStream(path)) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
                Student student = new Student();

                student.setName("xiaoming");
                student.setGradeName("3");
                student.setClassName("2");

                objectOutputStream.writeObject(student);
                objectOutputStream.flush();
                objectOutputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream inputStream = new FileInputStream(path)) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {

                Student student = (Student) objectInputStream.readObject();

                System.out.println(String.valueOf(student));

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}