package org.laidu.learn.io.nio;


import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.SocketChannel;

/**
 * worker
 * <p>
 * Created by 臧天才 on 2017-09-11 17:46.
 */
@Slf4j
//  : 2017-09-11 17:46  worker
public class Worker implements Runnable{

    private SocketChannel channel;

    private ByteBuffer buffer;

    public Worker(SocketChannel channel,ByteBuffer buffer) {
        this.channel = channel;
        this.buffer = buffer;
    }

    @Override
    public void run() {

        buffer.flip();
        try {
            channel.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer.flip();
        while (buffer.get()==0){
            buffer.flip();
            try {
                channel.write(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            buffer.flip();
        }

        try {
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
