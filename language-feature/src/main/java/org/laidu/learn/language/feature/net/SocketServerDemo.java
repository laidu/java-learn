package org.laidu.learn.language.feature.net;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        ServerSocket server = new ServerSocket(8081);

       while (true){
           Socket accept = server.accept();


           BufferedReader reader = new BufferedReader(new InputStreamReader(accept.getInputStream()));

           String request = reader.readLine();

           log.info(" request :\n{}",request);

           String content = "{\"nihao\":123}";

           String message = "HTTP/1.1 200 OK\n" +
                   "content-type: application/json; charset=UTF-8\n\n" +
                   content+"\n";

           accept.getOutputStream().write(message.getBytes());

           accept.close();
       }
    }

}