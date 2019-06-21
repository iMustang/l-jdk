package container.collection.list;

import java.util.LinkedList;

/**
 * @Title: TreeMapDemo
 * @Description: 使用LinkedList实现队列
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/18 0:45
 */
public class App3 {
    public static void main(String[] args) {
        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.put("a");
        myQueue.put("b");
        myQueue.put("c");

        while(!myQueue.isEmpry()){
            System.out.println(myQueue.get());
        }
    }
}

class MyQueue<T> {
    private LinkedList<T> linkedList = new LinkedList<>();

    // 入队
    public void put(T t) {
        linkedList.addLast(t);
    }

    // 出队
    public T get() {
        return linkedList.removeFirst();
    }

    // 判空
    public boolean isEmpry() {
        return linkedList.isEmpty();
    }
}
