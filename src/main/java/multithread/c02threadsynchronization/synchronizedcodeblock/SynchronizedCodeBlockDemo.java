package multithread.c02threadsynchronization.synchronizedcodeblock;

/**
 * SynchronizedCodeBlockDemo
 * description: 同步代码块示例
 */
public class SynchronizedCodeBlockDemo {
	public static void main(String[] args) {
		BankAccount aBankAccount = new BankAccount("xMustang", 1000);
		new DrawThread("取钱线程a", aBankAccount, 800).start();
		new DrawThread("取钱线程b", aBankAccount, 800).start();
	}
}
