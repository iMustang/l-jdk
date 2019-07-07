package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {
	public static void main(String[] args) throws IOException {
		readTest2();
		readTest4();
	}

	static void readTest4() throws IOException {
		File file = new File("F:/a.txt");
		FileInputStream fileInputStream = new FileInputStream(file);
		int length;
		byte[] buf = new byte[1024];
		while ((length = fileInputStream.read(buf)) != -1) {
			System.out.print(new String(buf, 0, length));
		}
		fileInputStream.close();
	}

	static void readTest2() throws IOException {
		File file = new File("F:/a.txt");
		FileInputStream fileInputStream = new FileInputStream(file);
		int content;
		while ((content = fileInputStream.read()) != -1) {
			System.out.print((char) content);
		}
		fileInputStream.close();
	}


}
