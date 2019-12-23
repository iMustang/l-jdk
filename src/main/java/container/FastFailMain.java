package container;

import java.util.ArrayList;

/**
 * 快速失败机制——fast-fail
 *
 * @author: xMustang
 * @since: 1.0
 */
public class FastFailMain {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");

		for (String tmp : list) {
			if (tmp.equals("b")) {
				list.remove(tmp);
				list.add("d");
			}
		}
	}
}
