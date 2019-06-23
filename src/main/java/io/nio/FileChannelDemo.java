package io.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Title: FileChannelDemo
 * @Description:
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019-06-23 16:17
 */
public class FileChannelDemo {
	public static void main(String[] args) throws IOException {
		RandomAccessFile file = new RandomAccessFile("/nio-data.txt", "r");
		FileChannel inChannel = file.getChannel();

		ByteBuffer buf = ByteBuffer.allocate(48);

		int bytesRead = inChannel.read(buf);
		while (bytesRead != -1) {

			System.out.println("Read " + bytesRead);
			buf.flip();

			while (buf.hasRemaining()) {
				System.out.print((char) buf.get());
			}
			buf.clear();
			bytesRead = inChannel.read(buf);
		}
		file.close();

	}
}
