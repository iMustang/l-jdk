package multithread.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExceptionThreadMain
 * main线程不能捕获其他线程抛出的异常
 *
 * @author xMustang
 * @version 1.0
 * 2020/1/11 9:15 下午
 */
public class ExceptionThreadMain implements Runnable {

    @Override
    public void run() {
        System.out.println("准备抛出异常");
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ExceptionThreadMain());
        try {
            ExecutorService service = Executors.newCachedThreadPool();
            service.execute(thread);
            service.shutdown();
        } catch (Exception e) {
            System.out.println("我捕捉到异常了");
            e.printStackTrace();
        }
    }
}