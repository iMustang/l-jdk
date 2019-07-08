package regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java操作正则表达式示例
 */
public class RegularDemo1 {
	public static void main(String[] args) {
		String testStr = "This is my small example string which I'm going " +
				"to use for pattern matching";

		Pattern pattern = Pattern.compile("\\w+");

		Matcher matcher = pattern.matcher(testStr);

		while (matcher.find()) {
			System.out.print("start pos:" + matcher.start());
			System.out.print(" end pos:" + matcher.end());
			System.out.print(" word:" + matcher.group());
			System.out.println("");
		}
	}
}
