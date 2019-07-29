package multithread.c07lockobject.s04reentrantreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLockThread1
 * description: 读锁共享
 */
public class ReentrantReadWriteLockThread1 extends Thread {
	private ReentrantReadWriteLock lock;

	public ReentrantReadWriteLockThread1(ReentrantReadWriteLock lock) {
		this.lock = lock;
	}

	public void run() {
		lock.readLock().lock();

		System.out.println(Thread.currentThread().getName() + " start time:" + System.currentTimeMillis());
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "正在进行读操作...");
		}
		System.out.println(Thread.currentThread().getName() + "：读操作完毕！");
		System.out.println(Thread.currentThread().getName() + " end time:" + System.currentTimeMillis());
		lock.readLock().unlock();
	}

	public static void main(String[] args) {
		ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
		new ReentrantReadWriteLockThread1(lock).start();
		new ReentrantReadWriteLockThread1(lock).start();
	}
}
