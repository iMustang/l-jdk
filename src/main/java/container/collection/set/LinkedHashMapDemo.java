package container.collection.set;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashMapDemo {
	public static void main(String[] args) {
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add("张三");
		linkedHashSet.add("李四");
		linkedHashSet.add("李四");
		linkedHashSet.add("王五");

		for (String str : linkedHashSet) {
			System.out.println(str);
		}

		Iterator<String> it = linkedHashSet.iterator();
		while (it.hasNext()) {
			String next = it.next();
			System.out.println(next);
		}
	}
}
