package container.util;

import java.util.Arrays;
import java.util.List;

public class ArraysDemo {
	public static void main(String[] args) {
		Integer[] moreInts = {4, 5, 6, 7};
		// 返回的是Arrays的内部类ArrayList
		List<Integer> list = Arrays.asList(moreInts);

		list.set(2, 90);
		System.out.println(list);
		// Arrays的内部类ArrayList，使用数组实现，添加值会引发异常。
		// 下面代码报UnsupportedOperationException
//        list.add(12);
	}
}