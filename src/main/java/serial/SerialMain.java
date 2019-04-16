package serial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 序列化测试类
 * 
 * @author xMustang
 *
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
