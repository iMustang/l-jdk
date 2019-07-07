package container.collection.set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSet示例，自定义Comparator接口
 */
public class TreeSetDemo3 {
	public static void main(String[] args) {
		TreeSet<Student> studentTreeSet = new TreeSet<>(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getAge() - o2.getAge();
			}
		});
		studentTreeSet.add(new Student("张三", 12));
		studentTreeSet.add(new Student("李四", 42));
		studentTreeSet.add(new Student("王五", 23));

		Iterator<Student> it = studentTreeSet.iterator();
		while (it.hasNext()) {
			Student next = it.next();
			System.out.println(next);
		}
	}
}

class Student {
	private String name;
	private int age;

	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
