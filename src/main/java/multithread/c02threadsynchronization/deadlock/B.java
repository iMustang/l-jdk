package multithread.c02threadsynchronization.deadlock;

/**
 * B
 * description:
 */
public class B {
	public synchronized void bar(A a) {
		System.out.println(Thread.currentThread().getName() + " 进入B-bar()");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " 企图调用A-last()");
		a.last();
	}

	public synchronized void last() {
		System.out.println("进入B-last()");
	}
}