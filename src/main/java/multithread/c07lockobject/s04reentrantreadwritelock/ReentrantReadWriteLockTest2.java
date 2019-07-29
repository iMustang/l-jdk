package multithread.c07lockobject.s04reentrantreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLockTest2
 * description: 这段代码不会导致死锁，但没有正确的释放锁。从写锁降级成读锁，并不会自动释放当前线程获取的写锁，仍然需要显式地释放写锁，否则别的线程永远获取不到写锁。
 */
public class ReentrantReadWriteLockTest2 {
	public static void main(String[] args) {
		final ReentrantReadWriteLock rtlock = new ReentrantReadWriteLock();

		rtlock.writeLock().lock();
		System.out.println("get write lock");

		rtlock.readLock().lock();
		System.out.println("get read lock");

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					rtlock.writeLock().lock();
					System.out.println(Thread.currentThread().getName() + "：进入写锁");
				} finally {
					rtlock.readLock().unlock();
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					rtlock.readLock().lock();
					System.out.println(Thread.currentThread().getName() + "：进入读锁");
				} finally {
					rtlock.readLock().unlock();
				}
			}
		}).start();
	}
}
