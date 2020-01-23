package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

public class CloseStreamDemo {
	/**
	 * 关闭流时，只要关闭最上层的流即可，系统会自动关闭下层的流。
	 */
	public static void main(String[] args) {
		File file = new File("ProgramIOFile/io.txt");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = fis.read(buffer)) != -1) {
				System.out.println(new String(buffer, 0, length));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		// Java7 trycatch resource
		File f = new File("ProgramIOFile/io.txt");
		try (FileWriter writer = new FileWriter(f)) {
			writer.write("今天天气很好");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
