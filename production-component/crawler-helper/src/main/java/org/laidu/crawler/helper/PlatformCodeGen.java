package org.laidu.crawler.helper;


import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import jodd.io.FileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * platform code generater
 * <p>
 * Created by tiancai.zang on 2017-11-02 18:23.
 */
@Slf4j
public class PlatformCodeGen {

    public static void main(String[] args) throws IOException, PinyinException {

        final String[] txtString = FileUtil.readLines(PlatformCodeGen.class.getClassLoader().getResource("template/platformCode.txt").getFile());
        final List<String> repetitionPlamformCode = new ArrayList<>();


        final Set<String> pinyinNameSet = new HashSet<>();

        for (String var : txtString) {

            String[] nameValuePair = var.split("\t");
            String pinYinName = PinyinHelper.convertToPinyinString(nameValuePair[0], "", PinyinFormat.WITHOUT_TONE);

            String pinYinNameWithPrefix = pinYinName + nameValuePair[1].split("_")[0].toLowerCase();

            if (pinyinNameSet.contains(pinYinName) && !pinyinNameSet.contains(pinYinNameWithPrefix)){
                pinYinName = pinYinNameWithPrefix.toLowerCase();
            }

            if (pinyinNameSet.contains(pinYinNameWithPrefix)){
                repetitionPlamformCode.add(var);
            } else {
                String enumName = pinYinName.matches("^[0-9].*") ? "A" + pinYinName.toUpperCase() : pinYinName.toUpperCase();
                System.out.println(String.format("%s(\"%s\",\"%s\",\"%s\"),", enumName, nameValuePair[0], pinYinName.toLowerCase(), nameValuePair[1]));
            }

            pinyinNameSet.add(pinYinNameWithPrefix);
            pinyinNameSet.add(pinYinName);

        }

        System.out.println("repetition platform code :");
        repetitionPlamformCode.forEach(System.out::println);

    }
}