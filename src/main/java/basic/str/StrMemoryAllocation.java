package basic.str;

/**
 * 字符串内存分配
 */
public class StrMemoryAllocation {
	public static void main(String[] args) {
		String str1 = "aaa";
		String str2 = "bbb";
		String str3 = "aaabbb";
		String str4 = str1 + str2;
		String str5 = "aaa" + "bbb";

		System.out.println(str1 == new String("aaa"));// false
		System.out.println(str3 == str4);// false
		System.out.println(str3 == str4.intern());// true
		System.out.println(str3 == str5);// true
	}
}
