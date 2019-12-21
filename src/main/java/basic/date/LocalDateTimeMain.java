package basic.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * LocalDateTimeMain
 *
 * @author xMustang
 * @since 1.0
 */
public class LocalDateTimeMain {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        System.out.println(ldt);
        System.out.println(ld);
        System.out.println(lt);

        LocalDate ld2 = LocalDate.of(2019, 12, 23);
        System.out.println(ld2);
        LocalTime lt2 = LocalTime.of(13, 35, 43);
        System.out.println(lt2);
        LocalDateTime ldt2 = LocalDateTime.of(2019, 12, 23, 11, 23, 42);
        System.out.println(ldt2);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String dateStr = dtf.format(LocalDateTime.now());
        System.out.println(dateStr);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime ldt3 = now.minusDays(2).plusHours(2).minusMinutes(20);
        System.out.println(ldt3);

        LocalDateTime ldt4 = now.withHour(23);
        System.out.println(ldt4);
    }
}
