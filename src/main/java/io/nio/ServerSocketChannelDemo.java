package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelDemo {
	public static void main(String[] args) throws IOException {
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.socket().bind(new InetSocketAddress(8090));

		while (true) {
			SocketChannel socketChannel = serverSocketChannel.accept();
			if (socketChannel != null) {

				ByteBuffer buf = ByteBuffer.allocate(48);
				buf.clear();
				int bytesRead = socketChannel.read(buf);
				System.out.println("接收到客户端发送的数据为：");
				while (bytesRead != -1) {
					buf.flip();
					while (buf.hasRemaining()) {
						System.out.print((char) buf.get());
					}
					buf.clear();
					// TODO: 阻塞到这里，这个ServerSocket不能用，找出原因
					bytesRead = socketChannel.read(buf);
				}

				String newData = "Hello Server";
				buf.clear();
				buf.put(newData.getBytes());
				buf.flip();
				while (buf.hasRemaining()) {
					socketChannel.write(buf);
				}
				socketChannel.close();
			}
		}
	}
}
