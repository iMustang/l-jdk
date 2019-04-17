package serial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @Title: SerialMain
 * @Description: 序列化测试类
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/17 10:06
 */
public class SerialMain {
    public static void main(String[] args) throws IOException {
        Person person = new Person(1234, "wang", "男", "山东济南");
        System.out.println("Person Serial" + person);
        FileOutputStream fos = new FileOutputStream("Person.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(person);
        oos.flush();
        oos.close();
    }
}
