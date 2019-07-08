package container.collection.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Arrays.asList底层原理
 */
public class ArraysAsListDemo {
	public static void main(String[] args) {
		Integer[] ia = {1, 2, 3, 4, 5, 6};
		List<Integer> integers = Arrays.asList(ia);
		System.out.println(integers);

		Collections.shuffle(integers);
		System.out.println(integers);

		// Arrays.asList底层使用了上面的ia数组，打乱后，底层ia数组也变化了
		System.out.println(Arrays.toString(ia));
	}

}
