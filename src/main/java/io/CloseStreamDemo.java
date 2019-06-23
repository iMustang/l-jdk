package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

/**
 * @Title: CloseStreamDemo
 */
public class CloseStreamDemo {
	/**
	 * 关闭流时，只要关闭最上层的流即可，系统会自动关闭下层的流。
	 */
	public static void main(String[] args) {
		File file = new File("ProgramIOFile/io.txt");
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		// Java7 try resource
		File f = new File("ProgramIOFile/io.txt");
		try (FileWriter writer = new FileWriter(f)) {
			writer.write("今天天气很好");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
