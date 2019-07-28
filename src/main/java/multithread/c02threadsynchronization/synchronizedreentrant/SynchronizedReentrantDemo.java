package multithread.c02threadsynchronization.synchronizedreentrant;

/**
 * SynchronizedReentrantDemo
 * description: synchronized锁可重入
 */
public class SynchronizedReentrantDemo {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				new A().method1();
			}
		}).start();
	}
}

class A {
	public synchronized void method1() {
		System.out.println("method1");
		method2();
	}

	public synchronized void method2() {
		System.out.println("method2");
		method3();
	}

	public synchronized void method3() {
		System.out.println("method3");
	}
}
