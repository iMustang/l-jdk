package container.collection.set;

import java.util.Iterator;
import java.util.TreeSet;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * TreeSet示例，自定义实现Comparable接口
 */
public class TreeSetDemo2 {
	public static void main(String[] args) {
		TreeSet<Person> personTreeSet = new TreeSet<>();
		personTreeSet.add(new Person("张三", 18));
		personTreeSet.add(new Person("李四", 12));
		personTreeSet.add(new Person("王五", 20));

		Iterator<Person> it = personTreeSet.iterator();
		while (it.hasNext()) {
			Person next = it.next();
			System.out.println(next);
		}
	}
}

@ToString
@AllArgsConstructor
class Person implements Comparable<Person> {
	private String name;
	private int age;

	@Override
	public int compareTo(Person o) {
		return this.age - o.age;
	}

}