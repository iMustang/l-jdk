package container.collection.list;

import java.util.LinkedList;

/**
 * 使用LinkedList模拟栈
 */
public class SimulateStackDemo {
	public static void main(String[] args) {
		MyStack<String> myStack = new MyStack<>();
		myStack.push("a");
		myStack.push("b");
		myStack.push("c");

		while (!myStack.isEmpty()) {
			System.out.println(myStack.pop());
		}
	}
}

class MyStack<T> {
	private LinkedList<T> linkedList = new LinkedList<>();

	// 压栈
	void push(T t) {
		linkedList.addFirst(t);
	}

	// 出栈
	T pop() {
		return linkedList.removeFirst();
	}

	// 判断空栈
	boolean isEmpty() {
		return linkedList.isEmpty();
	}
}
