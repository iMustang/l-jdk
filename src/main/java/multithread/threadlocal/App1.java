package multithread.threadlocal;

/**
 * @Title: HashMapTraverse
 * @Description: 学习ThreadLocal的用法
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/16 14:21
 */
public class App1 {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Transfer t = new Transfer(bank);
        Thread t1 = new Thread(t);
        t1.start();
        Thread t2 = new Thread(t);
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Main线程中的ThreadLocal
        System.out.println(bank.get());
    }
}
