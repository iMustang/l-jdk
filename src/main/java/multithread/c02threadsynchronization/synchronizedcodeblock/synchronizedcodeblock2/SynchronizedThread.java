package multithread.c02threadsynchronization.synchronizedcodeblock.synchronizedcodeblock2;

/**
 * title: SynchronizedThread
 * description:
 */
public class SynchronizedThread extends Thread {
    private SynchronizedObject object;

    public SynchronizedThread(SynchronizedObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        object.print();
    }
}
