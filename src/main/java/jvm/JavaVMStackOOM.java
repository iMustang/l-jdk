package jvm;

/**
 * @Title: Java
 * @Description: 虚拟机栈和本地方法栈溢出，方式二：多线程
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/21 12:26
 */
public class JavaVMStackOOM {
    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
