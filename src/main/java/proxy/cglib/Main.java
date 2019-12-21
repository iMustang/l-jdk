package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Main
 *
 * @author xMustang
 * @since 1.0
 */
public class Main {
    public static void main(String[] args) {
        // 1. 创建Enhancer对象
        Enhancer enhancer = new Enhancer();
        // 2. 指定父类Class对象
        enhancer.setSuperclass(Person.class);
        // 3. 设置方法拦截回调
        enhancer.setCallback(new PersonIntercept());

        // 4. 创建被代理的对象
        Person person = (Person) enhancer.create();
        person.speak();
    }
}
