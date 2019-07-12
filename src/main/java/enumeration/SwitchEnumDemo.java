package enumeration;

/**
 * SwitchEnumDemo
 * description:
 * author: xMustang
 * version: 1.0
 * created: 2019/7/12 17:29
 */
public class SwitchEnumDemo {
	public static void main(String[] args) {
		Season season = Season.SUMMER;
		switch (season) {
			case SPRING:
				System.out.println("this is spring");
				break;
			case SUMMER:
				System.out.println("this is summer");
				break;
			case AUTUMN:
				System.out.println("this is autumn");
				break;
			case WINTER:
				System.out.println("this is winter");
				break;
		}
	}
}
