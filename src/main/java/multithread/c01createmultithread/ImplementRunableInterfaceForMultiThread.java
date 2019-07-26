package multithread.c01createmultithread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ImplementRunableInterfaceForMultiThread
 * description: 创建多线程方式二，实现Runnale接口
 */
public class ImplementRunableInterfaceForMultiThread {
	public static void main(String[] args) {
		BPrintThread bPrintThread = new BPrintThread();
		Thread t = new Thread(bPrintThread, "打印线程");
		// 启动线程
		t.start();

		// 主线程打印时间
		System.out.println("当前线程是：" + Thread.currentThread().getName());
		for (int i = 0; i < 1000000; i++) {
			System.out.println(Thread.currentThread().getName() + "打印当前时间：" + new SimpleDateFormat("HH-mm-ss").format(new Date(System.currentTimeMillis())));
		}
	}
}

class BPrintThread implements Runnable {
	@Override
	public void run() {
		System.out.println("当前线程是："
				+ Thread.currentThread().getName());
		for (int i = 0; i < 3000000; i++) {
			System.out.println(Thread.currentThread().getName() + "正在打印第" + (i + 1) + "个字符");
		}
	}
}
