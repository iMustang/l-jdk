package multithread.c03threadcommunication.waitnotify;

/**
 * DrawThread
 * description:取钱线程
 */
public class DrawThread extends Thread {
	private Account account;
	private double drawAmount;

	public DrawThread(String name, Account account,
	                  double drawAmount) {
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}

	// 重复100次执行取钱操作
	public void run() {
		for (int i = 0; i < 300; i++) {
			account.draw(drawAmount);
		}
	}
}
