package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Title: FileWriterDemo
 */
public class FileWriterDemo {
	public static void main(String[] args) throws IOException {
		writeTest();
	}
	public static void writeTest() throws IOException {
		File file = new File("F:/temp.txt");
		FileWriter fileWriter = new FileWriter(file, true);
		String data = "今天天气非常好！！";
		fileWriter.write(data); // 字符流具备解码的功能。
		// 刷新字符流
		// fileWriter.flush();
		fileWriter.close();
	}
}