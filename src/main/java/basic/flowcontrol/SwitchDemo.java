package basic.flowcontrol;

import java.util.Random;

/**
 * SwitchDemo
 * desc
 *
 * @author xMustang
 * @since 1.0
 */
public class SwitchDemo {
    public static void main(String[] args) {
        String type = "d";

        switch (type) {
            case "a":
                System.out.println("aaaa");
                break;
            case "b":
                System.out.println("bbbb");
                return;
        }

        method(null);
    }

    public static void method(String param) {
        switch (param) {
            // 肯定不是进入这里
            case "sth":
                System.out.println("it's sth");
                break;
            // 也不是进入这里
            case "null":
                System.out.println("it's null");
                new Random().nextInt(12);
                break;
            // 也不是进入这里
            default:
                System.out.println("default");
        }
    }
}
