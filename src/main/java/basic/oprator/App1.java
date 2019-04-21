package basic.oprator;

/**
 * @Title: App1
 * @Description: 按位操作符、移位运算符
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/20 18:39
 */
public class App1 {
    public static void main(String[] args) {
        int a = 10;
        System.out.println(Integer.toBinaryString(a));

        // 1010（二进制）
        int b = 0x0a;
        // 0111（二进制）
        int c = 0x07;
        int d = b & c;
        System.out.println(Integer.toBinaryString(d));

        int e = -23546;
        System.out.println(Integer.toBinaryString(e));
        int f = e >> 1;
        System.out.println(Integer.toBinaryString(f));
    }
}
