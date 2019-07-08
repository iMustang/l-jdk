package generic;

/**
 * 泛型类
 */
public class GenericClassDemoTest {
	public static void main(String[] args) {
		GenericClassDemo<String> genericClassDemo = new GenericClassDemo<String>("hello");
		String key = genericClassDemo.getKey();
		System.out.println(key);
		genericClassDemo.setKey("world");
		System.out.println(genericClassDemo.getKey());
		// 不能对确切的泛型类型使用instanceof操作
		// 下面代码报错
//        if (genericClassDemo instanceof GenericClassDemo<String>) {
//
//        }
		// 测试静态方法使用泛型
		GenericClassDemo.sayKey("java");
	}
}

/**
 * 泛型类
 *
 * @param <T>
 */
class GenericClassDemo<T> {
	private T key;

	GenericClassDemo(T key) {
		this.key = key;
	}

	// 静态函数不能用类上的自定义泛型，类上定义的泛型为构造对象时非静态变量使用
	// 静态函数不能引用非静态变量
	// 若静态函数使用泛型，须在函数上自定义泛型。
	// 以下方法报错
//    public static void sayKey(T key){
//        System.out.println(key);
//    }
	static <V> void sayKey(V key) {
		System.out.println(key);
	}

	void setKey(T key) {
		this.key = key;
	}

	T getKey() {
		return key;
	}
}