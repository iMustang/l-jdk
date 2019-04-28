package basic.constructor;

/**
 * @Title: Son
 * @Description: 构造器、初始化块的执行顺序
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/25 22:29
 */
public class Son extends Father {

    public Son() {
        System.out.println("子类构造器执行");
        j = 3;
    }

    {
        System.out.println("子类初始化块");
        j = 2;
    }

    private int j = initJ();

    public int initJ() {
        System.out.println("子类成员变量定义时赋值");
        return 1;
    }

    public static void main(String[] args) {
        new Son();
    }
}
