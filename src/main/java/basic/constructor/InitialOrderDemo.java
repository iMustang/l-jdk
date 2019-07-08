package basic.constructor;

/**
 * 初始化顺序
 */
public class InitialOrderDemo {
	static int b;
	int a;

	{
		System.out.println("初始化块前a：" + a);
		a = 1;
	}

	static {
		System.out.println("静态初始化块前b：" + b);
		b = 8;
	}

	public InitialOrderDemo(int a, int c) {
		System.out.println("构造方法前a：" + this.a);
		System.out.println("构造方法前c：" + this.c);
		this.a = a;
		this.c = c;
		System.out.println("构造方法后a：" + this.a);
		System.out.println("构造方法后c：" + this.c);
	}

	int c;

	{
		System.out.println("初始化块前c：" + c);
		c = 3;
	}

	public static void main(String[] args) {
		new InitialOrderDemo(2, 5);
		System.out.println("静态字段b：" + InitialOrderDemo.b);
	}

}
