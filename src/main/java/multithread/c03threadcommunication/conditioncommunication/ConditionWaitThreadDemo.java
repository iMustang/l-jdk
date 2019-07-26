package multithread.c03threadcommunication.conditioncommunication;

/**
 * ConditionWaitThreadDemo
 * description:
 */
public class ConditionWaitThreadDemo {
	public static void main(String[] args) {
		// 创建一个账户
		Account acct = new Account("7654321", 0);
		new DrawThread("取钱者xMustang", acct, 800).start();
		new DepositThread("存款者甲", acct, 800).start();
		new DepositThread("存款者乙", acct, 800).start();
		new DepositThread("存款者丙", acct, 800).start();
	}
}