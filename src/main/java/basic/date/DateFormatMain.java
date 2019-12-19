package basic.date;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * DateFormatMain
 * <p>
 * SimpleDateFormat线程不安全
 *
 * @author: xMustang
 * @since: 1.0
 */
public class DateFormatMain {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
	private static String date[] = {"01-Jan-1999", "09-Jan-2000", "08-Jan-2001",
			"07-Jan-2002", "06-Jan-2003", "05-Jan-2004",
			"04-Jan-2005", "03-Jan-2006", "02-Jan-2007"};

	public static void main(String[] args) {
		for (int i = 0; i < date.length; i++) {
			final int temp = i;
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						while (true) {
							String str1 = date[temp];
							String str2 = sdf.format(sdf.parse(str1));
							System.out.println(Thread.currentThread().getName() + ", " + str1 + "," + str2);
							if (!str1.equals(str2)) {
								throw new RuntimeException(Thread.currentThread().getName()
										+ ", Expected " + str1 + " but got " + str2);
							}
						}
					} catch (Exception e) {
						throw new RuntimeException("parse failed", e);
					}
				}
			}).start();
		}
	}
}
