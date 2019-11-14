package basic.override;

/**
 * title: Son
 * description:
 */
public class Son extends Father {
    public void say() {
        System.out.println("son say");
    }

    public void speak() {
        System.out.println("son speak");
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.say();

//        ((Father) son).say();


        // 多态
        son.speak();

        Father father = new Son();
        father.speak();
    }
}
