package basic.constructor;

class Father {
    private int i = initI();

    Father() {
        System.out.println("父类构造器执行");
        i = 3;
    }

    {
        System.out.println("父类初始化块");
        i = 2;
    }

    private int initI() {
        System.out.println("父类成员变量定义时赋值");
        return 1;
    }
}
