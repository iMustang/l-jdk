package generic;

/**
 * 泛型方法
 */
public class GenericMethodDemoTest {
	public static void main(String[] args) {
		String str = new GenericMethodDemo().getElement("hello");
		System.out.println(str);

		String world = new GenericMethodDemo().<String>getElement("world");
		System.out.println(world);
	}
}

class GenericMethodDemo {
	public <E> E getElement(E e) {
		return e;
	}
}