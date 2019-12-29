package jvm;

/**
 * StackErrorMock
 * 测试栈调用深度，发现不是一个固定值
 *
 * @author xMustang
 * @since 1.0
 */
public class StackErrorMock {
    private static int index = 1;

    public void call() {
        index++;
        call();
    }

    public static void main(String[] args) {
        StackErrorMock mock = new StackErrorMock();
        try {
            mock.call();
        } catch (Throwable e) {
            System.out.println("Stack deep : " + index);
            e.printStackTrace();
        }
    }
}
