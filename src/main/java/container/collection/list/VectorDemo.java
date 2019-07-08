package container.collection.list;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Vector示例
 */
public class VectorDemo {
	public static void main(String[] args) {
		Vector<String> vector = new Vector<>();
		vector.add("a");
		vector.add("b");
		vector.add("c");

		Enumeration<String> elements = vector.elements();
		while (elements.hasMoreElements()) {
			System.out.println(elements.nextElement());
		}
	}
}
