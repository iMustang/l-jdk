package io;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringReaderDemo {
	public static void main(String[] args) throws IOException {
		String src = "今天天气很好";
		StringReader stringReader = new StringReader(src);
		char[] charbuffer = new char[32];
		int hasRead = 0;
		while ((hasRead = stringReader.read(charbuffer)) > 0) {
			System.out.print(new String(charbuffer, 0, hasRead));
		}

		StringWriter stringWriter = new StringWriter();
		stringWriter.write("今天天气很好");
		System.out.println(stringWriter);
	}
}
