package multithread.thisescape;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: EventSource
 * @Description:
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019-06-26 22:54
 */
public class EventSource<T> {

	private final List<T> eventListeners;

	public EventSource() {
		eventListeners = new ArrayList<T>();
	}

	public synchronized void registerListener(T eventListener) {
		this.eventListeners.add(eventListener);
		this.notifyAll();
	}

	public synchronized List<T> retrieveListeners() throws InterruptedException {
		List<T> dest = null;
		if (eventListeners.size() <= 0) {
			this.wait();
		}
		dest = new ArrayList<T>(eventListeners.size());
		dest.addAll(eventListeners);
		return dest;
	}
}
