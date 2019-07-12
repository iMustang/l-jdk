package enumeration;

import java.util.EnumMap;

/**
 * EnumMapDemo
 * description:EnumMap示例
 */
public class EnumMapDemo {
	public static void main(String[] args) {
		EnumMap<WeekDayEnum, RainbowColorEnum> schema = new EnumMap<>(WeekDayEnum.class);
		for (int i = 0; i < WeekDayEnum.values().length; i++) {
			schema.put(WeekDayEnum.values()[i], RainbowColorEnum.values()[i]);
		}
		System.out.println("what is the lucky color today");
		System.out.println("it's " + schema.get(WeekDayEnum.FRI));
	}
}
