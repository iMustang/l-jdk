package multithread.c07lockobject.s04reentrantreadwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLockTest1
 * description: 在同一个线程中，在没有释放读锁的情况下，就去申请写锁，属于锁升级，ReentrantReadWriteLock是不支持的。
 */
public class ReentrantReadWriteLockTest1 {
	public static void main(String[] args) {
		ReentrantReadWriteLock rtlock = new ReentrantReadWriteLock();
		rtlock.readLock().lock();
		System.out.println("get readLock");
		rtlock.writeLock().lock();
		System.out.println("bolcking");
	}
}
