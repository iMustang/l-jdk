package io.iopattern.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.io.IOUtils;

/**
 * IOServerThreadPool
 * description:BIO下的服务器实现三：
 * 使用线程池处理请求。为了防止连接请求过多，导致服务器创建的线程数过多，造成过多线程上下文切换的开销。可以通过线程池来限制创建的线程数。
 */
public class IOServerThreadPool {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(8090));
        while (true) {
            final Socket socket = serverSocket.accept();
            executorService.submit(() -> {
                try (InputStream is = socket.getInputStream();) {
                    System.out.println(IOUtils.toString(is, StandardCharsets.UTF_8));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
