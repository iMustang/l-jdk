import java.lang.ref.SoftReference;

/**
 * @title: Main
 * @description:
 * @author: xMustang
 * @version: 1.0
 * @create: 2019-06-30 12:33
 */
public class Main {
	public static void main(String[] args) {
		SoftReference<String> stringSoftReference = new SoftReference<String>(new String("Hello"));
		System.out.println(stringSoftReference.get());
	}
}
