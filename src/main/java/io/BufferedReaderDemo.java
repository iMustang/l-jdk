package io;

import java.io.*;
import java.util.Arrays;

public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        readTest1();

        File file = new File("F:/a.txt");
        FileReader fileReader = new FileReader(file);
        String line;
        while ((line = myReadLine(fileReader)) != null) {
            System.out.println(line);
        }
    }

    // 自实现readLine方法。
    private static String myReadLine(FileReader fileReader) throws IOException {
        StringBuilder sb = new StringBuilder();
        int content;
        while ((content = fileReader.read()) != -1) {
            if (content == '\r') {
                continue;
            } else if (content == '\n') {
                break;
            } else {
                sb.append((char) content);
            }
        }
        if (content == -1) {
            return null;
        }
        return sb.toString();
    }

    static void readTest1() throws IOException {
        File file = new File("F:/a.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
//		 int content = bufferedReader.read();
        // System.out.println((char)content);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        System.out.println(Arrays.toString("\r\n".getBytes()));
        bufferedReader.close();
    }

}
