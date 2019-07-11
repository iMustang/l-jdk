package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class SelectorDemo {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.socket().bind(new InetSocketAddress(8090));
        channel.configureBlocking(false);
        Selector selector = Selector.open();
        channel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            int readyChannels = selector.select();
            if (readyChannels == 0) continue;
            Set selectedKeys = selector.selectedKeys();
            Iterator it = selectedKeys.iterator();

            while (it.hasNext()) {
                SelectionKey selectionKey = (SelectionKey) it.next();
                if (selectionKey.isAcceptable()) {
                    System.out.println("connection accepted");
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();

                    SocketChannel socket = serverSocketChannel.accept();
                    socket.configureBlocking(false);
                    socket.register(selectionKey.selector(), SelectionKey.OP_READ);
                } else if (selectionKey.isConnectable()) {
                    // a connection was established with a remote server.
                    System.out.println("connection established");
                } else if (selectionKey.isReadable()) {
                    // a channel is ready for reading
                    System.out.println("channel ready reading");
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(128);
                    buffer.clear();

                    if (socketChannel.read(buffer) == -1) {
                        socketChannel.close();
                    } else {
                        buffer.flip();
                        String receivedRequestData =
                                Charset.forName("UTF-8").newDecoder().decode(buffer).toString();
                        System.out.println("接收到客户端的消息是：" + receivedRequestData);

                        String responseData = "Hello Client";
                        buffer = ByteBuffer.wrap(responseData.getBytes("UTF-8"));
                        socketChannel.write(buffer);
                        socketChannel.close();
                    }
                } else if (selectionKey.isWritable()) {
                    // a channel is ready for writing
                    System.out.println("channel ready writing");
                }

                // 注意每次迭代末尾的keyIterator.remove()调用。Selector不会自己从已选择键集中移除SelectionKey实例。
                // 必须在处理完通道时自己移除。下次该通道变成就绪时，Selector会再次将其放入已选择键集中。
                it.remove();
            }
        }

    }
}
