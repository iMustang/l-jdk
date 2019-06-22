package basic;



/**
 * @Title: LinkedHashMapDemo
 * @Description: 初始化顺序
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/23 10:09
 */
public class App2 {
    static int b;
    int a;

    {
        System.out.println("初始化块前a：" + a);
        a = 1;
    }

    static {
        System.out.println("静态初始化块前b：" + b);
        b = 8;
    }

    public App2(int a, int c) {
        System.out.println("构造方法前a：" + this.a);
        System.out.println("构造方法前c：" + this.c);
        this.a = a;
        this.c = c;
        System.out.println("构造方法后a：" + this.a);
        System.out.println("构造方法后c：" + this.c);
    }

    int c;

    {
        System.out.println("初始化块前c：" + c);
        c = 1;
    }

    public static void main(String[] args) {
        new App2(2, 5);
        System.out.println("静态字段b：" + App2.b);
    }

}
