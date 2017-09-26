package org.laidu.learn.io.nio.channel;


import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Channel的基础示例
 * <p>
 * Created by 臧天才 on 2017-09-11 16:13.
 */
@Slf4j
//  : 2017-09-11 16:13  Channel的基础示例
public class BasicChannelExample {

    /**
     * FileChannel 负责文件的读写
     * @throws IOException
     */
    public void fileChannelExa() throws IOException {

        String filePath = BasicChannelExample.class.getClassLoader().getResource("data/nio-data.txt").getFile();
        RandomAccessFile aFile = new RandomAccessFile(filePath , "rw");

        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }

    public static void main(String[] args) throws IOException {

        BasicChannelExample channelExample = new BasicChannelExample();
        channelExample.fileChannelExa();
    }
}
