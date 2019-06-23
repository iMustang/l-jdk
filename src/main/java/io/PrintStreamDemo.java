package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @Title: PrintStreamDemo
 */
public class PrintStreamDemo {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("ProgramIOFile/io.txt");
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		PrintStream printStream = new PrintStream(fileOutputStream);
		printStream.println("今天天气很好");
		printStream.close();
	}
}
