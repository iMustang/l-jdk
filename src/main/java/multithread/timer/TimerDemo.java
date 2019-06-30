package multithread.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @title: TimerDemo
 * @description:
 */
public class TimerDemo {
	public static void main(String[] args) throws InterruptedException {
		// 虽然只执行一次，但线程不会停止
//		Timer timer = new Timer();
		// 设置成守护线程，非守护线程全部停止后，也会停止运行。
		Timer timer = new Timer(true);
		TimerTask timerTask = new MyTask();

		timer.schedule(timerTask, 500);

		Thread.sleep(1000);

	}
}

class MyTask extends TimerTask {

	@Override
	public void run() {
		System.out.println("执行了");
	}
}
