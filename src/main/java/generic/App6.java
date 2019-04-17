package generic;

/**
 * @Title: App6
 * @Description: 泛型方法与可变参数
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/17 12:56
 */
public class App6 {
    public static void main(String[] args) {
        String[] strArr = new String[]{"a", "b", "c"};
        new GenericMethodDemo3().pringMsg(strArr);
    }
}

class GenericMethodDemo3 {
    public <T> void pringMsg(T... args) {
        for (T t : args) {
            System.out.println(t);
        }
    }
}
