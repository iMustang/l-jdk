package basic.packing;

/**
 * FloatDemo
 * desc
 *
 * @author xMustang
 * @since 1.0
 */
public class FloatDemo {
    public static void main(String[] args) {
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;

        if (a == b) {
            System.out.println("a==b");
        }

        Float x = Float.valueOf(a);
        Float y = Float.valueOf(b);
        if (x.equals(y)) {
            System.out.println("x.equals(y)");
        }

        Float x1 = Float.valueOf(0.1f);
        Float x2 = Float.valueOf(0.1f);
        if (x1.equals(x2)) {
            System.out.println("x1.equals(x2)");
        }
    }
}
