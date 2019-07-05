package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @title: StreamDemo
 * @description:
 */
public class StreamDemo {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("A", "B", "C", null);
		long count = list.stream().filter(element -> element != null).count();
		System.out.println(count);

		// 获得Stream对象
		Stream<String> stream = Stream.of("1", "2", "3");
		Stream<Double> limit = Stream.generate(() -> Math.random()).limit(10);
		limit.forEach((value) -> System.out.println(value));
		// Collection接口有一个stream方法，所以其所有子类都都可以获取对应的Stream对象。
//		Stream<String> col = list.stream();

		List<Integer> nums = Arrays.asList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10, 23, 12, 34);
		IntStream intStream = nums.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2).peek(num ->
				System.out.println("消费：" + num)
		).skip(2).limit(4);
		System.out.println(Arrays.toString(intStream.toArray()));
	}
}
