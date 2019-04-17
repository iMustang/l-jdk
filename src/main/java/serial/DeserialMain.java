package serial;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @Title: DeserialMain
 * @Description: 反序列化
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/17 10:05
 */
public class DeserialMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person;
        FileInputStream fis = new FileInputStream("Person.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        person = (Person) ois.readObject();
        ois.close();
        System.out.println("Person Deserial" + person);
    }
}
