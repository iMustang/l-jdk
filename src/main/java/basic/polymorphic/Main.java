package basic.polymorphic;

/**
 * Main
 * 多态
 * @author xMustang
 * @version 1.0
 * 2020/1/22 10:21 下午
 */
public class Main {
    static class Father{
        public void say(){
            System.out.println("i am father");
        }
    }
    static class Son extends Father{
        @Override
        public void say() {
            System.out.println("i am son");
        }
    }

    public static void main(String[] args) {
        Main.Father obj = new Main.Son();
        obj.say();
    }
}
