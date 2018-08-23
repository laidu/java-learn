package org.laidu.learn.commons.net.ftp;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;
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
    private final static String HOST = "http://linux.linuxidc.com";
    private final static int PORT = 21;
    private final static String USER_NAME = "www.linuxidc.com";
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

        String pathName = new String(path.getBytes("GBK"), "iso-8859-1");
        if (client.changeWorkingDirectory(pathName)) {
            FTPFile[] fs = client.listFiles(pathName);

            for (FTPFile ftpFile : fs) {

                if (".".equals(ftpFile.getName()) || "..".equals(ftpFile.getName())) {
                    continue;
                }
                if (ftpFile.isFile()) {
                    System.out.println(ftpFile.getName() + " >>>> " + path + "/" + ftpFile.getName());
                } else if (ftpFile.isDirectory()) {
                    listAllFiles(client, path + "/" + ftpFile.getName());
                }
            }
        } else {
            log.error(" change dir {} error", path);
        }

    }


    public static void main(String[] args) throws IOException {

        FTPClient client = connectFTPServer();
        client.enterLocalPassiveMode();//被动模式
        client.setControlEncoding(encoding);
        client.setFileType(FTPClient.BINARY_FILE_TYPE);
        client.setCharset(Charset.forName("utf-8"));

        listAllFiles(client, "");

    }


}