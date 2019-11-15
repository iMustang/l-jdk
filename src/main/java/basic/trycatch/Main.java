package basic.trycatch;

import java.util.Scanner;

/**
 * title: Main
 * description:
 */
public class Main {
    public static void main(String[] args) {
        //当在try块或catch块中遇到return 语句时，finally语句块将在方法返回之前被执行。
        System.out.println(returnValue());

    }

    public static int returnValue() {
        try {
            return 1;
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
//            return 3;
        }
        return 2;
    }

}
