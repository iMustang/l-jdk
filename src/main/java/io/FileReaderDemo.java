package io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Title: FileReaderDemo
 */
public class FileReaderDemo {
	public static void main(String[] args) throws IOException {
		readTest2();
	}

	public static void readTest2() throws IOException {
		File file = new File("F:/a.txt");
		FileReader fileReader = new FileReader(file);
		char[] buf = new char[1024];
		int length;
		while ((length = fileReader.read(buf)) != -1) {
			System.out.print(new String(buf, 0, length));
		}
		fileReader.close();
	}

	public static void readTest1() throws IOException {
		File file = new File("F:/a.txt");
		FileReader fileReader = new FileReader(file);
		int content;
		while ((content = fileReader.read()) != -1) {
			System.out.print((char) content);
		}
		fileReader.close();
	}
}
