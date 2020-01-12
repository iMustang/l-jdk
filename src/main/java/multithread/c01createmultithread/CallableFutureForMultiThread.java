package multithread.c01createmultithread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * CallableFutureForMultiThread
 * description: 创建多线程的方式三：Future、Callable
 */
public class CallableFutureForMultiThread {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "打印当前时间：" + new SimpleDateFormat("HH-mm-ss").format(new Date(System.currentTimeMillis())));
		}

		FutureTask<Integer> fTask = new FutureTask<>(() -> {
			for (int i = 0; i < 200; i++) {
				System.out.println(Thread.currentThread().getName() + "正在打印第" + (i + 1) + "个字符");
			}
			// call()方法有返回值
			return 0;
		});
		new Thread(fTask, "有返回值的打印线程").start();

		System.out.println("主线程的打印任务完成，被get()阻塞");
		try {
			System.out.println("打印线程的返回值是：" + fTask.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		// fTask.get()会阻塞主线程
		System.out.println("fTask.get()会阻塞主线程");
	}
}
