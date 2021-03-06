package io.iopattern.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

/**
 * IOServerMultiThread
 * description: BIO下的服务器实现二：
 * 为每个请求创建一个线程
 */
public class IOServerMultiThread {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(8090));
        while (true) {
            final Socket socket = serverSocket.accept();
            new Thread(() -> {
                try (InputStream is = socket.getInputStream();) {
                    System.out.println(IOUtils.toString(is, StandardCharsets.UTF_8));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
