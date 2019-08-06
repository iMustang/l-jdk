package basic.constructor;

/**
 * 代码已被笔记使用
 */
class Father {
	public Father() {
		System.out.println("父类构造器执行");
		i = 3;
	}

	{
		System.out.println("父类初始化块");
		i = 2;
	}

	public int initI() {
		System.out.println("父类成员变量定义时赋值（显式初始化）");
		return 1;
	}

	private int i = initI();

}
