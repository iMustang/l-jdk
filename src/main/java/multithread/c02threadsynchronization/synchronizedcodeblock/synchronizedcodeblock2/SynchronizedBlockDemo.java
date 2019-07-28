package multithread.c02threadsynchronization.synchronizedcodeblock.synchronizedcodeblock2;

/**
 * title: SynchronizedBlockDemo
 * description: 其他线程仍然可以访问该对象的同步代码块之外的代码
 */
public class SynchronizedBlockDemo {
    public static void main(String[] args) {
        SynchronizedObject object = new SynchronizedObject();
        new SynchronizedThread(object).start();
        new SynchronizedThread(object).start();
    }
}
