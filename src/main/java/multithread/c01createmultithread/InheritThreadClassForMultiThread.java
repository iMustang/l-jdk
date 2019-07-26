package multithread.c01createmultithread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * InheritThreadClassForMultiThread
 * description: 创建多线程的方式一，继承Thread
 */
public class InheritThreadClassForMultiThread {
	public static void main(String[] args) {
		Thread aprintThread = new APrintThread();
		// 启动PrintThread线程
		aprintThread.start();

		// 主线程打印当前时间
		System.out.println("当前线程是：" + Thread.currentThread().getName());
		for (int i = 0; i < 1000000; i++) {
			System.out.println(Thread.currentThread().getName() + "打印当前时间：" + new SimpleDateFormat("HH-mm-ss").format(new Date(System.currentTimeMillis())));
		}
	}
}

class APrintThread extends Thread {
	@Override
	public void run() {
		// 继承Thread的线程类，可以直接使用this获取当前线程对象
		// 线程名字：默认情况下，主线程名字为main
		// 用户启动的线程名字依次是Thread-0、Thread-1...Thread-n。
		this.setName("打印线程");
		System.out.println("当前线程是：" + this.getName());
		for (int i = 0; i < 3000000; i++) {
			System.out.println(Thread.currentThread().getName() + "正在打印第" + (i + 1) + "个字符");
		}
	}
}
