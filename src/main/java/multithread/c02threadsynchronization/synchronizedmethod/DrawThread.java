package multithread.c02threadsynchronization.synchronizedmethod;

/**
 * DrawThread
 * description:
 */
public class DrawThread extends Thread {
	private Account account;
	private double drawAmount;
	public DrawThread(String name, Account account, double drawAmount) {
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}
	public void run() {
		account.draw(drawAmount);
	}
}