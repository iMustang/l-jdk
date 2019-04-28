package basic.constructor;

/**
 * @Title: Father
 * @Description:
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/25 22:28
 */
public class Father {
    private int i = initI();

    public Father() {
        System.out.println("父类构造器执行");
        i = 3;
    }

    {
        System.out.println("父类初始化块");
        i = 2;
    }

    public int initI() {
        System.out.println("父类成员变量定义时赋值");
        return 1;
    }
}
