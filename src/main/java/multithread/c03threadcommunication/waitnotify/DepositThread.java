package multithread.c03threadcommunication.waitnotify;

/**
 * DepositThread
 * description:
 */
public class DepositThread extends Thread {
	private Account account;
	private double depositAmount;

	public DepositThread(String name, Account account,
	                     double depositAmount) {
		super(name);
		this.account = account;
		this.depositAmount = depositAmount;
	}

	// 重复100次执行存款操作
	public void run() {
		for (int i = 0; i < 100; i++) {
			account.deposit(depositAmount);
		}
	}
}