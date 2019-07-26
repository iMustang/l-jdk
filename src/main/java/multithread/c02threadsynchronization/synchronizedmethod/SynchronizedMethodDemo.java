package multithread.c02threadsynchronization.synchronizedmethod;

/**
 * SynchronizedMethodDemo
 * description: 同步方法示例
 */
public class SynchronizedMethodDemo {
	public static void main(String[] args) {
		Account account = new Account("Wild Horse", 1000);
		new DrawThread("取钱线程a", account, 800).start();
		new DrawThread("取钱线程b", account, 800).start();
	}
}
