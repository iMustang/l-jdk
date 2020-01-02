package basic.exception;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * App
 * try resouce
 *
 * @author xMustang
 * @since 1.0
 */
public class App {
    public static void main(String[] args) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream("F:/a.txt")) {
            int i = 1 / 0;
        }
    }
}
