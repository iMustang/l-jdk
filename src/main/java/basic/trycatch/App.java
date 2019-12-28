package basic.trycatch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * App
 *
 * @author xMustang
 * @since 1.0
 */
public class App {
    public static void main(String[] args) throws IOException {
        String fileName = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            System.out.println(builder.toString());
        }
    }
}
