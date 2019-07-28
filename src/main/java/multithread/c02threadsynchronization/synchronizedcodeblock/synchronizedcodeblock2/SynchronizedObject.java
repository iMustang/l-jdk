package multithread.c02threadsynchronization.synchronizedcodeblock.synchronizedcodeblock2;

/**
 * title: SynchronizedObject
 * description:
 */
public class SynchronizedObject {
    public void print() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }

        synchronized (this) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 200; i < 300; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }
}
