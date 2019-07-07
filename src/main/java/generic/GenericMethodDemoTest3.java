package generic;

/**
 * 泛型方法与可变参数
 */
public class GenericMethodDemoTest3 {
	public static void main(String[] args) {
		String[] strArr = new String[]{"a", "b", "c"};
		new GenericMethodDemo3().pringMsg(strArr);
	}
}

class GenericMethodDemo3 {
	public <T> void pringMsg(T... args) {
		for (T t : args) {
			System.out.println(t);
		}
	}
}
