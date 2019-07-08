package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class ScannerDemo {
	public static void main(String[] args) throws FileNotFoundException {
//		demo1();
//		demo2();
//		demo3();
		demo4();
	}

	static void demo1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入：");
		while (true) {
			String line = sc.nextLine();
			if (line.equals("exit"))
				break;
			System.out.println(">>" + line);
		}
		sc.close();
	}

	static void demo2() {
		Scanner sc = new Scanner("123 asdf,zxcv.bnm,qwe  rty");
		// sc.useDelimiter(" |,|\\.");
		while (sc.hasNext()) {
			System.out.println(sc.next());
		}
		sc.close();
	}

	static void demo3() {
		String str = null;
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter(",");// “,”作为分隔符
		while (sc.hasNext()) {
			str = sc.next();
			System.out.println(str);
		}
	}
	static void demo4() throws FileNotFoundException {
		InputStream in = new FileInputStream(new File("C:\\temp.java"));
		Scanner sc = new Scanner(in);
		while (sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
		sc.close();
	}
}
