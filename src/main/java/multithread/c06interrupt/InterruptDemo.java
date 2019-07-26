package multithread.c06interrupt;

/**
 * title: InterruptDemo
 * description: interrupt使用举例
 */
public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println(Thread.currentThread().getName() + " : 线程被中断了");
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + "在运行");
                }
            }
        });
        t.start();
        Thread.sleep(1000);
        t.interrupt();
        Thread.sleep(2000);
        System.out.println("main运行完成");
    }
}
