package multithread.thisescape;

import java.util.List;

/**
 * ListenerRunnable
 */
public class ListenerRunnable implements Runnable {

	private EventSource<EventListener> source;

	ListenerRunnable(EventSource<EventListener> source) {
		this.source = source;
	}

	public void run() {
		List<EventListener> listeners = null;
		try {
			listeners = this.source.retrieveListeners();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assert listeners != null;
		for (EventListener listener : listeners) {
			listener.onEvent(new Object());
		}
	}

}
