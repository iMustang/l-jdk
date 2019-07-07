package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {
	public static void main(String[] args) throws IOException {
		File file = new File("F:/a.txt");
		FileWriter fileWriter = new FileWriter(file, true);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		// bufferedWriter.newLine(); //newLine() 换行。 实际上就是向文件输出\r\n.
		bufferedWriter.write("今天天气真好");
		// bufferedWriter.flush();
		bufferedWriter.close();
	}
}
