package basic.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * SimpleDateFormatThreadLocalMain
 *
 * <p>SimpleDateFormat线程安全的方式
 *
 * @author xMustang
 * @since 1.0
 */
public class SimpleDateFormatThreadLocalMain {
    public static void main(String[] args) throws ParseException {
        String dateStr = "2015-12-02";
        Date date = DateUtil.parse(dateStr);
        System.out.println(date.getTime());

        String str = DateUtil.format(date);
        System.out.println(str);
    }
}

class DateUtil {
    private static ThreadLocal<SimpleDateFormat> local = new ThreadLocal<>();

    public static Date parse(String str) throws ParseException {
        SimpleDateFormat sdf = getThreadLocalSimpleDateFormat();
        return sdf.parse(str);
    }

    public static String format(Date date) {
        SimpleDateFormat sdf = getThreadLocalSimpleDateFormat();
        return sdf.format(date);
    }

    private static SimpleDateFormat getThreadLocalSimpleDateFormat() {
        SimpleDateFormat sdf = local.get();
        if (sdf == null) {
            sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
            local.set(sdf);
        }
        return sdf;
    }
}
