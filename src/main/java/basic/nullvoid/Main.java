package basic.nullvoid;

import java.util.Objects;

import org.junit.Assert;

/**
 * Main
 *
 * @author: xMustang
 * @since: 1.0
 */
public class Main {
	public static void main(String[] args) {
		String str = null;

		boolean equals = Objects.equals(str, "a");
		System.out.println(equals);

		Integer integer = null;
		System.out.println(integer instanceof Integer);

		boolean flag = null == null;
		System.out.println(flag);

		Assert.assertNotNull("str不能为null", str);
	}
}
