package multithread.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * CaptureUncaughtException
 * 使用UncaughtExceptionHandler捕获异常
 *
 * @author xMustang
 * @version 1.0
 * 2020/1/11 9:19 下午
 */
public class CaptureUncaughtExceptionMain {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool(new HandlerThreadFactory());
        es.execute(new ExceptionThread2());
        es.execute(new ExceptionThread3());
        es.shutdown();
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("\n [caugth:] " + e.toString());
    }
}

class ExceptionThread2 implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }
}

class ExceptionThread3 implements Runnable {
    @Override
    public void run() {
        throw new NullPointerException();
    }
}

class HandlerThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        //为每一个线程设置异常捕获器
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        return t;
    }
}