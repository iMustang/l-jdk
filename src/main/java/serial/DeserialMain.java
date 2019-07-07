package serial;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 反序列化
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
