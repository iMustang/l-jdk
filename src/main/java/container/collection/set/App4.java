package container.collection.set;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Title: App4
 * @Description: TreeSet示例，自定义实现Comparable接口
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/18 1:15
 */
public class App4 {
    public static void main(String[] args) {
        TreeSet<Person> personTreeSet = new TreeSet<>();
        personTreeSet.add(new Person("张三", 18));
        personTreeSet.add(new Person("李四", 12));
        personTreeSet.add(new Person("王五", 20));

        Iterator<Person> it = personTreeSet.iterator();
        while (it.hasNext()) {
            Person next = it.next();
            System.out.println(next);
        }
    }
}

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}