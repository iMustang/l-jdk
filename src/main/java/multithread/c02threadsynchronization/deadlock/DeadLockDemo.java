package multithread.c02threadsynchronization.deadlock;

/**
 * DeadLockDemo
 * description: 死锁示例
 */
public class DeadLockDemo implements Runnable {
	A a = new A();
	B b = new B();

	public void init() {
		Thread.currentThread().setName("主线程");
		a.foo(b);
	}

	public void run() {
		Thread.currentThread().setName("副线程");
		b.bar(a);
	}

	public static void main(String[] args) {
		DeadLockDemo dl = new DeadLockDemo();
		// 启动副线程
		new Thread(dl).start();
		dl.init();
	}
}