package basic.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * ZonedDateTimeMain
 *
 * @author xMustang
 * @since 1.0
 */
public class ZonedDateTimeMain {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);

        ZonedDateTime now1 = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(now1);

        LocalDateTime ldt = LocalDateTime.of(2018, 12, 23, 11, 43, 23);
        ZonedDateTime zonedDateTime = ldt.atZone(ZoneId.of("America/New_York"));
        System.out.println(zonedDateTime);

        ZonedDateTime now2 = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zdt = now2.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(zdt);
        LocalDateTime ldt2 = zdt.toLocalDateTime();
        System.out.println(ldt2);
    }
}
