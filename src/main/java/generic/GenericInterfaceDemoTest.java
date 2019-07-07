package generic;

/**
 * 泛型接口
 */
public class GenericInterfaceDemoTest {
	public static void main(String[] args) {
		ConcreteClassB<String> concreteClassB = new ConcreteClassB<String>();
		System.out.println(concreteClassB.next("hello"));
	}
}

class ConcreteClassB<T> implements GenericInterfaceDemo<T> {
	@Override
	public T next(T t) {
		return t;
	}
}

class ConcreteClassC implements GenericInterfaceDemo<String> {
	@Override
	public String next(String s) {
		return null;
	}
}

class ConcreteClassA implements GenericInterfaceDemo {

	@Override
	public Object next(Object o) {
		return null;
	}
}

interface GenericInterfaceDemo<T> {
	T next(T t);
}