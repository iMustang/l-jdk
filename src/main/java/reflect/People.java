package reflect;

/**
 * title: People
 * description:
 */
public class People {
    private static boolean firstCreate = true;

    public People() {
        if (firstCreate) {
            System.out.println("构造方法被调用，firstCreate为true");
            firstCreate = false;
        } else {
            System.out.println("构造方法被调用，但不是第一次被调用");
        }
    }
}
