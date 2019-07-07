package generic;

/**
 * @Title: TreeSetDemo2
 * @Description: 泛型方法
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/17 11:36
 */
public class App4 {
    public static void main(String[] args) {
        String str = new GenericMethodDemo().getElement("hello");
        System.out.println(str);

        String world = new GenericMethodDemo().<String>getElement("world");
        System.out.println(world);
    }
}

class GenericMethodDemo {
    public <E> E getElement(E e) {
        return e;
    }
}