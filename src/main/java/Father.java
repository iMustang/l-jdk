/**
 * @Title: Father
 * @Description:
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/26 14:11
 */
public class Father {
    public void a() {
        b();
    }

    private void b() {
        System.out.println("父类方法b");
    }

    public static void main(String[] args) {
        new Son().a();
    }
}
