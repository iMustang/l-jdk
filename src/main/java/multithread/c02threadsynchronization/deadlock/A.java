package multithread.c02threadsynchronization.deadlock;

/**
 * A
 * description:
 */
public class A {
	public synchronized void foo(B b) {
		System.out.println(Thread.currentThread().getName() + " 进入A-foo()");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " 企图调用B-last()");
		b.last();
	}

	public synchronized void last() {
		System.out.println("进入A-last()");
	}
}