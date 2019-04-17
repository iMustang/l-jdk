package multithread.threadlocal;

/**
 * @Title: Transfer
 * @Description:
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/16 14:25
 */
public class Transfer implements Runnable {
    Bank bank;

    public Transfer(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            bank.set();
            System.out.println(Thread.currentThread().getName() + " " + bank.get());
        }
    }
}
