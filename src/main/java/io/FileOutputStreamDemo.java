package io;

import java.io.*;
import java.util.Arrays;

public class FileOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		writeTest2();
		writeTest3();
	}

	static void writeTest3() throws IOException {
		File file = new File("F:/temp.txt");
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		String data = "abc";
		byte[] buf = data.getBytes();
		fileOutputStream.write(buf, 0, 3);
		fileOutputStream.close();
	}

	static void writeTest2() throws IOException {
		File file = new File("F:/temp.txt");
		// 流打开的文件，在流关闭前，往里面写数据，都是依次往里写入，而不是覆盖。只有在流关闭后重新打开流时，才会出现是否要在原来内容后使用追加方式，
		FileOutputStream fileOutputStream = new FileOutputStream(file, true);
		String data = "hello world";
		fileOutputStream.write(data.getBytes());
		fileOutputStream.close();
	}

}
