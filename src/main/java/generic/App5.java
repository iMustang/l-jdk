package generic;

/**
 * @Title: App5
 * @Description: 泛型方法二
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/17 12:47
 */
public class App5 {
    public static void main(String[] args) {
        GenericMethodDemo2<String> genericMethodDemo2 = new GenericMethodDemo2<>();
        genericMethodDemo2.print(new Integer(123));
    }
}

class GenericMethodDemo2<T> {
    // 泛型方法中的<T>可以与泛型类中声明的T不是同一种类型。
    public <T> void print(T t) {
        System.out.println(t);
    }

    // 这不是泛型方法，只是一个普通方法
    public T getValue(T t) {
        return t;
    }
}