package multithread.atomic;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * UnsafeTest
 *
 * @author xMustang
 * @since 1.0
 */
public class UnsafeTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);

        User user = new User();
        Field age = user.getClass().getDeclaredField("age");

        unsafe.putInt(user, unsafe.objectFieldOffset(age), 20);
        System.out.println(user.getAge());

    }

    static class User {
        private int age;

        public User() {
            this.age = 10;
        }

        public int getAge() {
            return this.age;
        }
    }
}
