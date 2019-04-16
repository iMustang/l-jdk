package multithread.threadlocal;

/**
 * @Title: Bank
 * @Description:
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/16 14:22
 */
public class Bank {
    ThreadLocal<Integer> t = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 100;
        }
    };

    public int get() {
        return t.get();
    }

    public void set() {
        t.set(t.get() + 10);
    }
}
