package multithread.thisescape;

/**
 * @Title: ThisEscapeTest
 * this引用逸出：https://blog.csdn.net/flysqrlboy/article/details/10607295
 */
public class ThisEscapeTest {
	public static void main(String[] args) {
		EventSource<EventListener> source = new EventSource<EventListener>();
		ListenerRunnable listRun = new ListenerRunnable(source);
		Thread thread = new Thread(listRun);
		thread.start();
		ThisEscape escape = new ThisEscape(source);
	}
}
