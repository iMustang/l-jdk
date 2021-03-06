package basic.constructor;

/**
 * 构造器、初始化块的执行顺序
 * <p>
 * 代码已被笔记使用
 */
public class Son extends Father {

	public Son() {
		System.out.println("子类构造器执行");
		j = 3;
	}

	{
		System.out.println("子类初始化块");
		j = 2;
	}

	private int j = initJ();

	public int initJ() {
		System.out.println("子类成员变量定义时赋值（显式初始化）");
		return 1;
	}

	public static void main(String[] args) {
		new Son();
	}
}
