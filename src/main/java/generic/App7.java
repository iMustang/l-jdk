package generic;

/**
 * @Title: ToArrayDemo
 * @Description: 泛型通配符
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/17 13:00
 */
public class App7 {
    public static void main(String[] args) {
        GenericWildcardExtendsDemo genericWildcardExtendsDemoDemo = new GenericWildcardExtendsDemo();

        GenericDemo<Integer> integerGenericDemo = new GenericDemo<>();
        GenericDemo<Long> longGenericDemo = new GenericDemo<>();

        genericWildcardExtendsDemoDemo.showElement(integerGenericDemo);
        genericWildcardExtendsDemoDemo.showElement(longGenericDemo);

        GenericDemo<String> stringGenericDemo = new GenericDemo<>();
        // 以下代码报错
//        genericWildcardDemo.showElement(stringGenericDemo);

        // 以下方法报错，需要? super Number
//        genericWildcardExtendsDemoDemo.showElement2(integerGenericDemo);

    }
}

class GenericWildcardExtendsDemo {
    public void showElement(GenericDemo<? extends Number> obj) {
        System.out.println(obj);
    }

    public void showElement2(GenericDemo<? super Number> obj) {
        System.out.println(obj);
    }

    // 泛型方法通配符
    public <T extends Number> void showKeyName(GenericDemo<T> container) {
        System.out.println(container);
    }
}

class GenericDemo<T> {

}

/**
 * 泛型类通配符示例
 *
 * @param <T>
 */
class GenericClassWildcardDemo<T extends Number> {

}