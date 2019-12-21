package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * TryResourceCloseDemo
 *
 * @author xMustang
 * @since 1.0
 */
public class TryResourceCloseDemo {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("F:\\a.txt");) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, length));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
