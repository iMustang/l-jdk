package multithread.threadlocal;

/**
 * 学习使用TheadLocal
 */
public class ThreadLocalDemo extends Thread {
	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
		protected Integer initialValue() {
			return 1;
		}
	};

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			Integer integer = threadLocal.get();
			System.out.println(Thread.currentThread().getName() + " : " + integer);
			threadLocal.set(integer + 1);
		}
	}

	public static void main(String[] args) {
		ThreadLocalDemo thread1 = new ThreadLocalDemo();
		ThreadLocalDemo thread2 = new ThreadLocalDemo();
		thread1.start();
		thread2.start();
	}
}