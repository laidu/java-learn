package org.laidu.commom.util.text.diff;

import jodd.io.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * text file diff
 * <p>
 * Created by tiancai.zang on 2017-12-12 18:48.
 */
@Slf4j
// : 2017/12/12 18/48
public class TextDiff {

    @Test
    public void diff() throws Exception {

        String file1 = FileUtil.readString(this.getClass().getClassLoader().getResource("reg-node-v1.4.2.txt").getFile());
        String file2 = FileUtil.readString(this.getClass().getClassLoader().getResource("reg-node-v1.4.3.txt").getFile());

        for (String var : file1.split("\n")){
            if (!file2.contains(var)) {
                System.out.println(var);
            }
        }

    }

}