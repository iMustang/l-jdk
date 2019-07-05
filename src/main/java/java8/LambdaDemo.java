package java8;

/**
 * @title: LambdaDemo
 * @description:
 */
public class LambdaDemo {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("原来的写法");
			}
		});

		Thread t2 = new Thread(() -> System.out.println("lambda写法"));

	}
}
