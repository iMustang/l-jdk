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
			Iterator keyIterator = selectedKeys.iterator();

			while (keyIterator.hasNext()) {
				SelectionKey selectionKey = (SelectionKey) keyIterator.next();
				if (selectionKey.isAcceptable()) {
					// a connection was accepted by a ServerSocketChannel.
					System.out.println("connection accepted");
					ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
					SocketChannel accept = serverSocketChannel.accept();
					accept.configureBlocking(false);
					accept.register(selectionKey.selector(), SelectionKey.OP_READ);
				} else if (selectionKey.isConnectable()) {
					// a connection was established with a remote server.
					System.out.println("connection established");
				} else if (selectionKey.isReadable()) {
					// a channel is ready for reading
					System.out.println("channel ready reading");
					//获取套接字通道
					SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
					//获取缓冲器并进行重置,selectionKey.attachment()为获取选择器键的附加对象
					ByteBuffer byteBuffer = ByteBuffer.allocate(128);
					byteBuffer.clear();
					//没有内容则关闭通道
					if (socketChannel.read(byteBuffer) == -1) {
						socketChannel.close();
					} else {
						//将缓冲器转换为读状态
						byteBuffer.flip();
						//将缓冲器中接收到的值按localCharset格式编码保存
						String receivedRequestData =
								Charset.forName("UTF-8").newDecoder().decode(byteBuffer).toString();
						System.out.println("接收到客户端的消息是：" + receivedRequestData);
						//返回响应数据给客户端
						String responseData = "Hello Client";
						byteBuffer = ByteBuffer.wrap(responseData.getBytes("UTF-8"));
						socketChannel.write(byteBuffer);
						//关闭通道
						socketChannel.close();
					}
				} else if (selectionKey.isWritable()) {
					// a channel is ready for writing
					System.out.println("channel ready writing");
				}
				keyIterator.remove();
			}
		}

	}
}
