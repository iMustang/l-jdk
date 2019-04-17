package serial;

import java.io.Serializable;

/**
 * @Title: Person
 * @Description: 序列化——子类
 * @Author: xMustang
 * @Version: 1.0
 * @create: 2019/4/17 10:06
 */
public class Person extends Animal implements Serializable {
    private static final long serialVersionUID = 123456789L;
    private int id;
    private String name;

    private transient String gender;

    public Person(int id, String name, String gender, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", gender=" + gender + ", address=" + address + "]";
    }
}
