package jvm;

/**
 * @Title: JavaVMStackSOF
 * @Description: 虚拟机栈和本地方法栈溢出，方式一：减少栈内存容量。
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/21 12:11
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
