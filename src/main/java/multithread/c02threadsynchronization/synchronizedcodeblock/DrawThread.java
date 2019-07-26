package multithread.c02threadsynchronization.synchronizedcodeblock;

/**
 * DrawThread
 * description:
 */
public class DrawThread extends Thread {
	private BankAccount account;// 模拟用户账户
	private double drawAmount;// 当前取钱线程所希望取的钱数

	public DrawThread(String name, BankAccount account,
	                  double drawAmount) {
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}

	public void run() {
		synchronized (account) {
			if (account.getBalance() >= drawAmount) {
				System.out.println(getName() + "取钱成功！取出:" + drawAmount);
				account.setBalance(account.getBalance() - drawAmount);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("余额为: " + account.getBalance());
			} else {
				System.out.println(getName() + "取钱失败！余额不足");
			}
		}
	}
}
