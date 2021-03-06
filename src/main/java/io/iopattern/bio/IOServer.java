package io.iopattern.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

/**
 * IOServer
 * BIO下服务器实现一：
 * 单线程逐个处理所有请求
 */
public class IOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(8090));
        while (true) {
            Socket socket = serverSocket.accept();
            InputStream is = socket.getInputStream();
            System.out.println(IOUtils.toString(is, StandardCharsets.UTF_8));
            IOUtils.closeQuietly(is);
        }
    }
}
