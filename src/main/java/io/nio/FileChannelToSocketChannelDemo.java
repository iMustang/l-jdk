package io.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * FileChannelToSocketChannelDemo
 * description: 使用FileChannel的零拷贝将本地文件内容传输到网络
 */
public class FileChannelToSocketChannelDemo {
	public static void main(String[] args) throws IOException {
		SocketChannel socketChannel = SocketChannel.open();
		InetSocketAddress address = new InetSocketAddress(8090);
		socketChannel.connect(address);
		RandomAccessFile file = new RandomAccessFile(FileChannelToSocketChannelDemo.class.getResource("/nio-data.txt").getFile(), "rw");
		FileChannel channel = file.getChannel();
		channel.transferTo(0, channel.size(), socketChannel);
		channel.close();
		file.close();
		socketChannel.close();
	}
}
