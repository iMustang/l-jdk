package basic.aslist;

import java.util.Arrays;
import java.util.List;

/**
 * Main
 * description:
 */
public class Main {
	public static void main(String[] args) {
		String[] str = {"a", "b"};
		List<String> list = Arrays.asList(str);

		System.out.println(list);

		str[0] = "c";
		System.out.println(list);

		int size = list.size();

		list.add("e");
	}
}
