package io;

import java.io.*;
import java.util.Scanner;

/**
 * @Title: RedirectIODemo
 */
public class RedirectIODemo {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner;
		FileInputStream fileInputStream = new FileInputStream(new File("ProgramIOFile/io.txt"));
		// 标准输入流重定向到文件
		System.setIn(fileInputStream);
		scanner = new Scanner(System.in);
		scanner.useDelimiter("\n");
		while (scanner.hasNext()) {
			System.out.println(scanner.next());
		}
		scanner.close();

		PrintStream printStream = new PrintStream(new FileOutputStream(new File("ProgramIOFile/io.txt")));
		// 标准输出流重定向到文件
		System.setOut(printStream);
		printStream.println("今天天气很好");

	}
}
