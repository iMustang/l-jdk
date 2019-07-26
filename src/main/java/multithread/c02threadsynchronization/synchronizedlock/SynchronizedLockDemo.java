package multithread.c02threadsynchronization.synchronizedlock;

/**
 * SynchronizedLockDemo
 * description: 同步锁示例
 */
public class SynchronizedLockDemo {
	public static void main(String[] args) {
		// 创建一个账户
		Account acct = new Account("1234567", 1000);
		// 模拟两个线程对同一个账户取钱
		new DrawThread("取钱线程a", acct, 800).start();
		new DrawThread("取钱线程b", acct, 800).start();
	}
}
