package basic.lambda;

/**
 * Main
 *
 * @author xMustang
 * @since 1.0
 */
public class Main {
	public static void main(String[] args) {
		Converter<String, Integer> converter = from -> Integer.valueOf(from);

		Converter<String, Integer> converter1 = Integer::valueOf;
	}
}
