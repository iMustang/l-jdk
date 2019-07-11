package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelDemo {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(8090));

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                socketChannel.configureBlocking(false);

                ByteBuffer buf = ByteBuffer.allocate(1024);
                buf.clear();
                int bytesRead = socketChannel.read(buf);
                System.out.println("接收到客户端发送的数据为：");
                while (bytesRead != -1) {
                    buf.flip();
                    while (buf.hasRemaining()) {
                        System.out.print((char) buf.get());
                    }
                    buf.clear();
                    bytesRead = socketChannel.read(buf);
                }
                socketChannel.shutdownInput();
                System.out.println();

                String newData = "Hello Client";
                buf.clear();
                buf.put(newData.getBytes());
                buf.flip();
                while (buf.hasRemaining()) {
                    socketChannel.write(buf);
                }
                socketChannel.shutdownOutput();
                socketChannel.close();
            }
        }
    }
}
