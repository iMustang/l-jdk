package basic.extend;

/**
 * @Title: Father
 * @Description: 继承时父类private特性
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
