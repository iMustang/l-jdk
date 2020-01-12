package multithread.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CaptureUncaughtExceptionMain2
 * 设置全局异常捕获器
 *
 * @author xMustang
 * @version 1.0
 * 2020/1/11 9:28 下午
 */
public class CaptureUncaughtExceptionMain2 {
    public static void main(String[] args) {
        //设置静态异常处理器
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());

        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(new ExceptionThread2());
        es.shutdown();
    }
}
