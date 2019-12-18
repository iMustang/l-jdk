package io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * StreamCloseDemo
 *
 * @author: xMustang
 * @since: 1.0
 */
public class StreamCloseDemo {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("F:\\a.txt");
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
