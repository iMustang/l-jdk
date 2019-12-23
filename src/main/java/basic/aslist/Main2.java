package basic.aslist;

import java.util.Arrays;
import java.util.List;

/**
 * Main2
 *
 * @author: xMustang
 * @since: 1.0
 */
public class Main2 {
	public static void main(String[] args) {
		// Arrays.asList是泛型方法，传入的对象必须是对象数组。
		// 当传入一个原生数据类型数组时，Arrays.asList() 的真正得到的参数就不是数组中的元素，而是数组对象本身
		int[] myArray = {1, 2, 3};
		List myList = Arrays.asList(myArray);
		int[] o = (int[]) myList.get(0);
		System.out.println(o);
		System.out.println(Arrays.toString(o));

		// 使用包装类型数组就可以解决上面问题
		Integer[] arr = {1, 2, 3};
		List<Integer> list = Arrays.asList(arr);
		Integer integer = list.get(1);
		System.out.println(integer);

		Object[] objects = list.toArray();
		Integer[] integers = list.toArray(new Integer[0]);
	}
}
