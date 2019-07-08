package io;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceInputStreamDemo {
	public static void main(String[] args) throws IOException {
		mergeFiles();
	}

	public static void mergeFiles() throws IOException {
		File file1 = new File("F:/a.txt");
		File file2 = new File("F:/b.txt");
		File file3 = new File("F:/c.txt");
		File file4 = new File("F:/d.txt");

		FileInputStream fileInputStream1 = new FileInputStream(file1);
		FileInputStream fileInputStream2 = new FileInputStream(file2);
		FileInputStream fileInputStream3 = new FileInputStream(file3);
		FileOutputStream fileOutputStream = new FileOutputStream(file4);

		Vector<FileInputStream> vector = new Vector<>();
		vector.add(fileInputStream1);
		vector.add(fileInputStream2);
		vector.add(fileInputStream3);
		Enumeration<FileInputStream> enumeration = vector.elements();
		SequenceInputStream sequenceInputStream = new SequenceInputStream(enumeration);

		byte[] buf = new byte[1024];
		int length;
		while ((length = sequenceInputStream.read(buf)) != -1) {
			fileOutputStream.write(buf, 0, length);
		}
		sequenceInputStream.close();
		fileOutputStream.close();
	}
}