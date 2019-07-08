package jvm;

/**
 * JConsole测试死锁
 */
public class JConsoleDemo3 {
	static class SynAddRunable implements Runnable {
		int a, b;

		public SynAddRunable(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public void run() {
			// 默认Integer在[-128,127]之间是被缓存的。所以，在这之间的对象都是同一个
			synchronized (Integer.valueOf(a)) {
				synchronized (Integer.valueOf(b)) {
					System.out.println(a + b);
				}
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(new SynAddRunable(1, 2)).start();
			new Thread(new SynAddRunable(2, 1)).start();
		}
	}
}
