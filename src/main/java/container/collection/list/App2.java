package container.collection.list;

import java.util.LinkedList;

/**
 * @Title: App2
 * @Description: 使用LinkedList模拟栈
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/18 0:35
 */
public class App2 {
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
    public void push(T t) {
        linkedList.addFirst(t);
    }

    // 出栈
    public T pop() {
        return linkedList.removeFirst();
    }

    // 判断空栈
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
