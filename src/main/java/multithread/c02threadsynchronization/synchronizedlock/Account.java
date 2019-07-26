package multithread.c02threadsynchronization.synchronizedlock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Account
 * description:
 */
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	private final ReentrantLock lock = new ReentrantLock();
	private String accountNo;
	private double balance;

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public double getBalance() {
		return this.balance;
	}

	public void draw(double drawAmount) {
		lock.lock();
		try {
			if (balance >= drawAmount) {
				System.out.println(Thread.currentThread().getName() + "取钱成功！吐出钞票:" + drawAmount);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				balance -= drawAmount;
				System.out.println("余额为: " + balance);
			} else {
				System.out.println(Thread.currentThread().getName() + "取钱失败！余额不足！");
			}
		} finally {
			lock.unlock();
		}
	}
}
