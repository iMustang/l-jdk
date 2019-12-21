package basic.exception;

/**
 * Main
 *
 * @author xMustang
 * @since 1.0
 */
public class Main {
    public static void main(String[] args) {
        NullPointerException ex = new NullPointerException();
        System.out.println(ex.getMessage());
        System.out.println(ex.toString());
        System.out.println(ex.getLocalizedMessage());

        ex.printStackTrace();
    }
}
