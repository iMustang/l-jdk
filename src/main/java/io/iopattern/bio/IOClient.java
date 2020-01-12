package io.iopattern.bio;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * IOClient
 *
 * @author xMustang
 * @version 1.0
 * 2020/1/12 9:11 下午
 */
public class IOClient {
    public static void main(String[] args) {
        // 创建多个线程，模拟多个客户端连接服务端
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8090);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
