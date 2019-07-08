package container.collection.list;

import java.util.LinkedList;

/**
 * 使用LinkedList实现队列
 */
public class SimulateQueue {
	public static void main(String[] args) {
		MyQueue<String> myQueue = new MyQueue<>();
		myQueue.put("a");
		myQueue.put("b");
		myQueue.put("c");

		while (!myQueue.isEmpry()) {
			System.out.println(myQueue.get());
		}
	}
}

class MyQueue<T> {
	private LinkedList<T> linkedList = new LinkedList<>();

	// 入队
	void put(T t) {
		linkedList.addLast(t);
	}

	// 出队
	public T get() {
		return linkedList.removeFirst();
	}

	// 判空
	boolean isEmpry() {
		return linkedList.isEmpty();
	}
}
