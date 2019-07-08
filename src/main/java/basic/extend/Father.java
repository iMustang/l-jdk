package basic.extend;

/**
 * 继承时父类private特性
 */
public class Father {
	public void a() {
		b();
	}

	private void b() {
		System.out.println("父类方法b");
	}

	public void c() {
		System.out.println("父类方法c");
	}

	public static void main(String[] args) {
		new Son().a();
		new Son().b();
		new Son().c();
	}
}
