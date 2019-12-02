package container.collection.set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * TreeSetDemo4
 *
 * @author: xMustang
 * @since: 1.0
 */
public class TreeSetDemo4 {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<>();
		set.add(1);
		set.add(3);
		set.add(5);
		set.add(10);
		set.add(4);
		set.add(4);
		// TreeSet不允许插入null
//		set.add(null);

		HashSet<Integer> set2 = new HashSet<>();
		set2.add(null);
		System.out.println(set2);

		System.out.println("----升序遍历-----");
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println("----降序遍历-----");
		Iterator<Integer> it2 = set.descendingIterator();
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}

		// 获取3,5之间的元素
		SortedSet<Integer> integers = set.subSet(3, 5);
		System.out.println(integers);
	}
}
