package multithread.exception;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * CaptureUncaughtExceptionMain3
 * 自定义的UncaughtExceptionHandler在Callable失效
 *
 * @author xMustang
 * @version 1.0
 * 2020/1/11 9:35 下午
 */
public class CaptureUncaughtExceptionMain3 {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyTask());
        new Thread(futureTask).start();
        try {
            Integer integer = futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("捕获到异常");
        }
    }

    private static final class MyTask implements Callable<Integer> {
        @Override
        public Integer call() {
            Thread.currentThread().setUncaughtExceptionHandler((t, e) -> {
                System.out.println("unchecked exception happened:");
                System.out.println(t.getId());
                System.out.println(t.getName());
                e.printStackTrace(System.out);
            });
            int sum = 0;
            for (int i = 4; i >= 0; i--) {
                sum += (12 / i);
            }
            return sum;
        }
    }
}
