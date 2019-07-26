package multithread.c03threadcommunication.waitnotify;

/**
 * WaitThreadDemo
 * description:存款账户开始余额为0，三个存款者存款，账户余额不为0时不能存款。
 * 取款者xMustang取款，且账户余额为0时不能取款
 */
public class WaitThreadDemo {
	public static void main(String[] args) {
		// 创建一个账户
		Account acct = new Account("1234567", 0);
		new DrawThread("取钱者xMustang", acct, 800).start();
		new DepositThread("存款者甲", acct, 800).start();
		new DepositThread("存款者乙", acct, 800).start();
		new DepositThread("存款者丙", acct, 800).start();
	}
}
