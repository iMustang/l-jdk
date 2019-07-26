package multithread.c02threadsynchronization.synchronizedmethod;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Account
 * description:
 */
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	private String accountNo;
	private double balance;

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountNo() {
		return accountNo;
	}

	// 因此账户余额不允许随便修改，所以只为balance提供getter方法，
	public double getBalance() {
		return this.balance;
	}

	public synchronized void draw(double drawAmount) {
		if (balance >= drawAmount) {
			// 吐出钞票
			System.out.println(Thread.currentThread().getName() + "取钱成功！吐出钞票:" + drawAmount);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance -= drawAmount;
			System.out.println("余额为: " + balance);
		} else {
			System.out.println(Thread.currentThread().getName() + "取钱失败！余额不足！");
		}
	}
}
