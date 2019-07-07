package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelDemo {
	public static void main(String[] args) throws IOException {
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.connect(new InetSocketAddress(8090));
		String newData = "Hello Server";
		ByteBuffer buf = ByteBuffer.allocate(48);
		buf.clear();
		buf.put(newData.getBytes());
		buf.flip();
		while (buf.hasRemaining()) {
			socketChannel.write(buf);
		}

		buf.clear();
		int bytesRead = socketChannel.read(buf);
		while (bytesRead != -1) {
			buf.flip();
			while (buf.hasRemaining()) {
				System.out.print((char) buf.get());
			}
			buf.clear();
			bytesRead = socketChannel.read(buf);
		}
		socketChannel.close();
	}
}
