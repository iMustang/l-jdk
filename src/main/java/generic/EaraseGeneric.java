package generic;

import java.util.ArrayList;

/**
 * 泛型擦除
 */
public class EaraseGeneric {
	public static void main(String[] args) {
		ArrayList<String> strList = new ArrayList<>();
		ArrayList<Integer> intList = new ArrayList<>();

		Class aClass = strList.getClass();
		Class bClass = intList.getClass();
		boolean result = aClass.equals(bClass);
		System.out.println(result);
	}
}
