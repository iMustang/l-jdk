package basic.extend;

/**
 * NoCreateFatherObject
 * description: 子类创建对象时，不会创建父类对象，只会创建父类亚对象
 */
public class NoCreateFatherObject {
	public static void main(String[] args) {
		new B();
	}
}

 class A {
	public A() {
		System.out.println(this);
	}
}
class B extends A {
	public B() {
		System.out.println(this);
	}
}