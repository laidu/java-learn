package org.laidu.learn.date.structure.tree.basic;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

/**
 * linux common line tool tree impl
 * <p>
 * Created by tiancai.zang
 * on 2018-04-01 23:33.
 */
@Slf4j
public class ListAllFiles {


    public static void printFile(File file){

        if (file.isDirectory()) {
            System.out.println(file.getName()+":");
            Arrays.stream(Objects.requireNonNull(file.listFiles())).forEach(ListAllFiles::printFile);
        }else {
            System.out.println("\t\t"+file.getPath()+"/"+file.getName());
        }
    }

    public static void main(String[] args) {

        File file = new File("~/Videos");
        printFile(file);

    }
}