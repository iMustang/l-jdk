package basic.constructor;

/**
 * NoParamConstructor
 *
 * @author xMustang
 * @since 1.0
 */
public class NoParamConstructor {
    public static void main(String[] args) {
        new Son1();
    }
}

class Father1 {
    Father1() {
        System.out.println("father1");
    }
}

class Son1 extends Father1 {
    Son1() {
        System.out.println("son1");
    }
}
