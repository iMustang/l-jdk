package multithread.thisescape;

import java.util.ArrayList;
import java.util.List;

/**
 * EventSource
 */
public class EventSource<T> {

	private final List<T> eventListeners;

	EventSource() {
		eventListeners = new ArrayList<>();
	}

	public synchronized void registerListener(T eventListener) {
		this.eventListeners.add(eventListener);
		this.notifyAll();
	}

	synchronized List<T> retrieveListeners() throws InterruptedException {
		List<T> dest;
		if (eventListeners.size() <= 0) {
			this.wait();
		}
		dest = new ArrayList<>(eventListeners.size());
		dest.addAll(eventListeners);
		return dest;
	}
}
