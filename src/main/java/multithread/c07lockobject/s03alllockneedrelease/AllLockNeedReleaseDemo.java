package multithread.c07lockobject.s03alllockneedrelease;

import java.util.concurrent.locks.ReentrantLock;

/**
 * AllLockNeedReleaseDemo
 * description: 重入锁，锁获取几次，就需要释放几次。如下面只释放了一次，导致了死锁。
 */
public class AllLockNeedReleaseDemo {
	public static void main(String[] args) throws InterruptedException {
		final ReentrantLock lock = new ReentrantLock();

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				lock.lock();
				System.out.println("Thread inner executing");
				lock.unlock();
			}
		});

		lock.lock();
		lock.lock();

		thread.start();
		Thread.sleep(1000);
		System.out.println("only release one lock");
		lock.unlock();
	}
}
