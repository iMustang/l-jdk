package container;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * SortDemo
 * Comparator在JDK7以后正确的使用方式
 *
 * @author xMustang
 * @since 1.0
 */
public class SortDemo {
    public static void main(String[] args) {
        System.out.println(new Integer(188) > new Integer(187));
        System.out.println(new Integer(188) == new Integer(188));

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(15, "xmustang"));
        persons.add(new Person(12, "horse"));

        persons.sort((o1, o2) ->
                o1.getAge() < o2.getAge() ? -1 : (o1.getAge().equals(o2.getAge()) ? 0 : 1)
        );
        System.out.println(persons);
    }
}

@AllArgsConstructor
@Getter
@ToString
class Person {
    private Integer age;
    private String name;
}