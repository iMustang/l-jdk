package multithread.aqs;

import java.util.concurrent.CyclicBarrier;

/**
 * TestMutex
 * 测试使用AQS自定义实现的Mutex
 *
 * @author xMustang
 * @since 1.0
 */
public class TestMutex {
    private static CyclicBarrier barrier = new CyclicBarrier(31);
    private static int a = 0;
    private static Mutex mutex = new Mutex();

    public static void main(String[] args) throws Exception {
        //说明:我们启用30个线程，每个线程对i自加10000次，同步正常的话，最终结果应为300000；

        //未加锁前
        for (int i = 0; i < 30; i++) {
            Thread t = new Thread(() -> {
                for (int i1 = 0; i1 < 10000; i1++) {
                    increment1();//没有同步措施的a++；
                }
                try {
                    barrier.await();//等30个线程累加完毕
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
        barrier.await();
        System.out.println("加锁前，a=" + a);


        //加锁后
        barrier.reset();//重置CyclicBarrier
        a = 0;
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                for (int i12 = 0; i12 < 10000; i12++) {
                    increment2();//a++采用Mutex进行同步处理
                }
                try {
                    barrier.await();//等30个线程累加完毕
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        barrier.await();
        System.out.println("加锁后，a=" + a);
    }

    /**
     * 没有同步措施的a++
     */
    public static void increment1() {
        a++;
    }

    /**
     * 使用自定义的Mutex进行同步处理的a++
     */
    public static void increment2() {
        mutex.lock();
        a++;
        mutex.unlock();
    }
}
