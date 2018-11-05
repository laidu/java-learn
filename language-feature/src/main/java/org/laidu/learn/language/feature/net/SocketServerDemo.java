package org.laidu.learn.language.feature.net;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket 服务其
 *
 * @author tiancai.zang
 * on 2018-11-05 19:15.
 */
@Slf4j
public class SocketServerDemo {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8080);

       while (true){
           Socket accept = server.accept();


           BufferedReader reader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
           String message = "HTTP/1.1 200 OK\n" +
                   "Date: Mon, 05 Nov 2018 11:50:21 GMT\n" +
                   "Server: Apache\n" +
                   "Last-Modified: Tue, 12 Jan 2010 13:48:00 GMT\n" +
                   "ETag: \"51-47cf7e6ee8400\"\n" +
                   "Accept-Ranges: bytes\n" +
                   "Content-Length: 81\n" +
                   "Cache-Control: max-age=86400\n" +
                   "Expires: Tue, 06 Nov 2018 11:50:21 GMT\n" +
                   "Connection: Keep-Alive\n" +
                   "Content-Type: application/html\n" +
                   "{\"nihao\":123}";


           FileInputStream fileInputStream  = new FileInputStream(new File("/home/laidu/Documents/e-book/高性能mysql第三版.pdf"));

           accept.getOutputStream().write(message.getBytes());

           accept.close();
       }
    }

}