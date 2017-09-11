package org.laidu.learn.io.bio;


import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * server
 * <p>
 * Created by 臧天才 on 2017-09-11 15:25.
 */
@Slf4j
//  : 2017-09-11 15:25  server
public class BioServer {

    // 通道管理器
    private Selector selector;

    public void initServer(int port) throws Exception {

        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);
        serverChannel.socket().bind(new InetSocketAddress(port));

        this.selector = Selector.open();

        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

    }

    // 采用轮训的方式监听selector上是否有需要处理的事件，如果有，进行处理
    public void listen() throws Exception {
        System.out.println("start server");
        while (true) {
            // 当注册事件到达时，方法返回，否则该方法会一直阻塞
            selector.select();

            Iterator ite = this.selector.selectedKeys().iterator();
            while (ite.hasNext()) {
                SelectionKey key = (SelectionKey) ite.next();

                ite.remove();
                // 客户端请求连接事件
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel channel = server.accept();
                    channel.configureBlocking(false);
                    // 在这里可以发送消息给客户端
                    write(channel,"hello world");
                    // 在客户端 连接成功之后，为了可以接收到客户端的信息，需要给通道设置读的权限
                    channel.register(this.selector, SelectionKey.OP_READ);
                    // 获得了可读的事件
                } else if (key.isReadable()) {
                    read(key);
                    write((SocketChannel) key.channel(),"hello world");
                }
            }

        }
    }

    // 处理 读取客户端发来的信息事件
    private void read(SelectionKey key) throws Exception {
        // 服务器可读消息，得到事件发生的socket通道
        SocketChannel channel = (SocketChannel) key.channel();
        // 穿件读取的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        channel.read(buffer);
        byte[] data = buffer.array();
        String msg = new String(data).trim();
        System.out.println("server receive from client: " + msg);
        ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
        channel.write(outBuffer);
    }

    // 处理 读取客户端发来的信息事件
    private void write(SocketChannel channel, String msg) throws Exception {

//        Thread.sleep();

        ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());

        channel.write(outBuffer);
    }



    public static void main(String[] args) throws Throwable {
        BioServer server = new BioServer();
        server.initServer(8080);
        server.listen();
    }
}
