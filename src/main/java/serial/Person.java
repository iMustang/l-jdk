package serial;

import java.io.Serializable;

/**
 * 序列化——子类
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
