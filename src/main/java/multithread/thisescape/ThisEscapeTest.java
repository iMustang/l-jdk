package multithread.thisescape;

/**
 * ThisEscapeTest
 * this引用逸出：https://blog.csdn.net/flysqrlboy/article/details/10607295
 */
public class ThisEscapeTest {
	public static void main(String[] args) throws InterruptedException {
		EventSource<EventListener> source = new EventSource<>();
		ListenerRunnable listRun = new ListenerRunnable(source);
		Thread thread = new Thread(listRun);
		thread.start();
		ThisEscape escape = new ThisEscape(source);
	}
}
