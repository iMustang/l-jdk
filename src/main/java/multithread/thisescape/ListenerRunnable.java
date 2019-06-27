package multithread.thisescape;

import java.util.List;

/**
 * @Title: ListenerRunnable
 * @Description:
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019-06-26 22:58
 */
public class ListenerRunnable implements Runnable {

	private EventSource<EventListener> source;

	public ListenerRunnable(EventSource<EventListener> source) {
		this.source = source;
	}

	public void run() {
		List<EventListener> listeners = null;

		try {
			listeners = this.source.retrieveListeners();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (EventListener listener : listeners) {
			listener.onEvent(new Object());
		}
	}

}
