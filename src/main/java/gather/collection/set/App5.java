package gather.collection.set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Title: App5
 * @Description: TreeSet示例，自定义Comparator接口
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/18 1:24
 */
public class App5 {
    public static void main(String[] args) {
        TreeSet<Student> studentTreeSet = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        studentTreeSet.add(new Student("张三", 12));
        studentTreeSet.add(new Student("李四", 42));
        studentTreeSet.add(new Student("王五", 23));

        Iterator<Student> it = studentTreeSet.iterator();
        while (it.hasNext()) {
            Student next = it.next();
            System.out.println(next);
        }
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
