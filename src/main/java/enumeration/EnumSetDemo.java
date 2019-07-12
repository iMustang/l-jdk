package enumeration;

import java.util.EnumSet;

/**
 * EnumSetDemo
 * description:EnumSet示例
 */
public class EnumSetDemo {
	public static void main(String[] args) {
		for (WeekDayEnum day : EnumSet.range(WeekDayEnum.MON, WeekDayEnum.THU)) {
			System.out.println(day);
		}

		System.out.println("========================");
		EnumSet<WeekDayEnum> subset = EnumSet.of(WeekDayEnum.TUE, WeekDayEnum.FRI);
		for (WeekDayEnum day : subset) {
			System.out.println(day);
		}
	}
}
