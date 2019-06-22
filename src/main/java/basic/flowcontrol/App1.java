package basic.flowcontrol;

/**
 * @Title: HashMapTraverse
 * @Description: break label
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/20 20:07
 */
public class App1 {
    public static void main(String[] args) {
        System.out.println("break label");
        int i = 0;
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
