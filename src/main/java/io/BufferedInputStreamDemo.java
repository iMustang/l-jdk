package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Title: BufferedInputStreamDemo
 */
public class BufferedInputStreamDemo {
	public static void main(String[] args) throws IOException {
		readTest();
		readTest2();
	}

	static void readTest2() throws IOException {
		File file = new File("F:/a.txt");
		FileInputStream fileInputStream = new FileInputStream(file);
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
		int content;
		// defaultBufferSize = 8192
		// BufferedInputStream内部byte数组大小为8192
		while ((content = bufferedInputStream.read()) != -1) {
			System.out.print((char) content);
		}
		bufferedInputStream.close();
	}

	/**
	 * 也可以自己创建数组，代替BufferedInputStream
	 */
	public static void readTest() throws IOException {
		File file = new File("F:/a.txt");
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] buf = new byte[1024 * 8];
		int length;
		while ((length = fileInputStream.read(buf)) != -1) {
			System.out.print(new String(buf, 0, length));
		}
		fileInputStream.close();
	}
}
