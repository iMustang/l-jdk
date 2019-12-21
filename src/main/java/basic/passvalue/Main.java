package basic.passvalue;

import lombok.Setter;

/**
 * Main
 *
 * @author xMustang
 * @since 1.0
 */
public class Main {
    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p);
        change(p);
        System.out.println(p);
    }

    // 上面p的引用传给person，在下面函数中，person又指向了一个新的对象，因此原来的p引用没有改变。
    static void change(Person person) {
        person = new Person();
    }

    // 如果在change中对person指向的对象操作，如下面，那么是将传入的引用指向的对象的内容改变了
//    static void change(Person person) {
//        person.setName("xMustang");
//    }

    @Setter
    static class Person {
        private String name;
    }
}
