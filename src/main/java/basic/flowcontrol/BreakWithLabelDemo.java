package basic.flowcontrol;

/**
 * break语句加上label的流程控制
 */
public class BreakWithLabelDemo {
    public static void main(String[] args) {
        System.out.println("break label");
        outer:
        while (true) {
            for (int j = 0; j < 10; j++) {
                System.out.println(j);
                if (j == 5) {
                    break outer;
                }
            }
        }
        System.out.println("end");
    }
}
