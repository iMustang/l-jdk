package io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Title: FileChannelDemo
 * @Description:
 */
public class FileChannelDemo {
	/**
	 * FileChannel无法设置为非阻塞模式，它总是运行在阻塞模式下
	 * <p>
	 * 无法直接打开一个FileChannel，需要通过使用一个FileInputStream、FileOutputStream或RandomAccessFile来获取一个FileChannel实例。
	 */
	public static void main(String[] args) throws IOException, URISyntaxException {
		URL resource = FileChannelDemo.class.getResource("/nio-data.txt");
		FileChannelDemo.class.getResourceAsStream("");
		RandomAccessFile file = new RandomAccessFile(new File(resource.toURI()), "rw");
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
		inChannel.close();
		file.close();

	}
}
