package io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Title: BufferedOutputStreamDemo
 */
public class BufferedOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		File file = new File("F:/temp.txt");
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		bufferedOutputStream.write("hello world".getBytes());
		// 把缓冲数组中的数据写到硬盘上面。
		// bufferedOutputStream.flush();
		bufferedOutputStream.close();
	}
}
