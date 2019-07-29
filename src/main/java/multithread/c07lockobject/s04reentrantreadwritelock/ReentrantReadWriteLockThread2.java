package multithread.c07lockobject.s04reentrantreadwritelock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLockThread2
 * description: 读写锁互斥
 */
public class ReentrantReadWriteLockThread2 {
	private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public void read() {
		lock.readLock().lock();
		boolean readLock = lock.isWriteLocked();
		if (!readLock) {
			System.out.println("当前为读锁");
		}
		try {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "：正在进行读操作。。。");
			}
			System.out.println(Thread.currentThread().getName() + "：读操作完毕！");
		} finally {
			System.out.println("释放读锁！");
			lock.readLock().unlock();
		}
	}

	public void write() {
		lock.writeLock().lock();
		boolean writeLock = lock.isWriteLocked();
		if (writeLock) {
			System.out.println("当前为写锁!");
		}
		try {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "：正在进行写操作...");
			}
			System.out.println(Thread.currentThread().getName() + "：写操作完毕！");
		} finally {
			System.out.println("释放写锁！");
			lock.writeLock().unlock();
		}
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.submit(new Runnable() {
			@Override
			public void run() {
				new ReentrantReadWriteLockThread2().read();
			}
		});

		executorService.submit(new Runnable() {
			@Override
			public void run() {
				new ReentrantReadWriteLockThread2().write();
			}
		});
	}
}
