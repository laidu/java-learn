package org.laidu.learn.commons.net.ftp;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.Charset;

/**
 * linux 公社 ftp
 *
 * @author tiancai.zang
 * @date 2018-03-07 10:25.
 */
@Slf4j
public class LinuxIDCBrower {

    //1~5
    private final static String HOST = "ftp1.linuxidc.com";
    private final static int PORT = 21;
    private final static String USER_NAME = "ftp1.linuxidc.com";
    private final static String PASSWORD = "www.linuxidc.com";
    private final static String encoding = "gb2312";


    public static FTPClient connectFTPServer() throws SocketException, IOException {
        // 实例化一个ftp客户端
        FTPClient ftpClient = new FTPClient();
        // 连接服务器
        log.info("HOST:" + HOST + " Port:" + PORT);
        ftpClient.connect(HOST, PORT);
        boolean isLogin = ftpClient.login(USER_NAME, PASSWORD);
        if (!isLogin) {
            throw new IOException("Login Ftp Server Fail,Plase Check Port,Host,user,password is all Rigth?");
        } else {
            log.info("Login Ftp Server Success!");
        }
        log.info("FTP Server Type:[" + ftpClient.getSystemType() + "]");
        return ftpClient;
    }

    public static void listAllFiles(FTPClient client, String path) throws IOException {


//        client.changeWorkingDirectory(path);
        FTPFile[] fs = client.listDirectories(path);

        for (FTPFile ftpFile : fs) {

            if (".".equals(ftpFile.getName()) || "..".equals(ftpFile.getName())) {
                continue;
            }
            if (ftpFile.isFile()) {
                System.out.println(ftpFile.getName());
            } else if (ftpFile.isDirectory()) {
                listAllFiles(client, path + "/" + ftpFile.getName());
            }
        }

    }


    public static void main(String[] args) throws IOException {

        FTPClient client = connectFTPServer();
        client.enterLocalPassiveMode();//被动模式
        client.setControlEncoding(encoding);

        listAllFiles(client, "/");

    }


}