package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * title: Main
 * description:
 */
public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        new People();

        Class<People> clazz = People.class;
        Constructor<People> constructor = clazz.getDeclaredConstructor();

        // 反射调用构造方法构建对象
        People people = constructor.newInstance();
        System.out.println(people);

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
            field.setAccessible(true);
            field.set(people, true);
        }

        System.out.println("----------");
        People people1 = constructor.newInstance();
        System.out.println(people1);

        // 反射构造对象仍然是通过构造方法
        System.out.println("----------");
        People people2 = clazz.newInstance();
        System.out.println(people2);
    }
}
