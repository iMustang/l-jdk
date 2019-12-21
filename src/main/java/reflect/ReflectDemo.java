package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ReflectDemo
 * <p>
 * 反射样例
 *
 * @author xMustang
 * @since 1.0
 */
public class ReflectDemo {
    static class Person implements Cloneable {
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<Person> clazz = Person.class;

        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c.getName());
        }

        Person person = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
            if (field.getName().equals("name")) {
                field.setAccessible(true);
                field.set(person, "宿城");
            }
        }

        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName());
        }

        System.out.println("================");

        System.out.println(person);
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
//            System.out.println(method.getName());
//            if ("setName".equals(method.getName())) {
//                method.invoke(person, "xMustang");
//            }
        }

        System.out.println(person);

    }
}
