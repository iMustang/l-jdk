package multithread.c02threadsynchronization.exceptionreleaselock;

import lombok.AllArgsConstructor;

/**
 * exceptionreleaselock
 * description: 线程发生异常，会释放锁
 */
@AllArgsConstructor
public class ExceptionReleaseLockDemo implements Runnable {
	private A a;

	public static void main(String[] args) {
		A a = new A();
		new Thread(new ExceptionReleaseLockDemo(a)).start();
		new Thread(new ExceptionReleaseLockDemo(a)).start();
	}

	@Override
	public void run() {
		a.method1();
	}
}

class A {
	public synchronized void method1() {
		System.out.println("进入method1");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		int a = 1 / 0;
	}
}
