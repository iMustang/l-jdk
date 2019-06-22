package generic;

/**
 * @Title: TreeMapDemo
 * @Description: 泛型接口
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/17 11:24
 */
public class App3 {
    public static void main(String[] args) {
        ConcreteClassB<String> concreteClassB = new ConcreteClassB<String>();
        System.out.println(concreteClassB.next("hello"));
    }
}

class ConcreteClassB<T> implements GenericInterfaceDemo<T> {
    @Override
    public T next(T t) {
        return t;
    }
}

class ConcreteClassC implements GenericInterfaceDemo<String> {
    @Override
    public String next(String s) {
        return null;
    }
}

class ConcreteClassA implements GenericInterfaceDemo {

    @Override
    public Object next(Object o) {
        return null;
    }
}

interface GenericInterfaceDemo<T> {
    T next(T t);
}