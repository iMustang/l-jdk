package basic.initblock;

/**
 * Main
 * description:
 */
public class Main {
	static {
		System.out.println("静态代码块");
	}

	public static void test() {
		System.out.println("静态方法");
		{
			System.out.println("静态方法中的代码块");
		}
	}

	public static void main(String[] args) {
		Main main = new Main();
		System.out.println("------------");
		Main.test();

		System.out.println("------------");
		Main a = null;
		a.test();
	}
}
