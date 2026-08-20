package Java8;

import java.time.*;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

public class DateTime {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        Month month = date.getMonth();
        int year = date.getYear();
        int dayOfMonth = date.getDayOfMonth();
        System.out.println(month);
        System.out.println(year);
        System.out.println(dayOfMonth);
        System.out.println("yesterday"+date.minusDays(1));
        System.out.println(date.minusMonths(100));
        System.out.println(date);

        LocalDate myDate = LocalDate.of(2003, 10, 26);
        System.out.println(myDate);
        LocalTime now = LocalTime.now();
        System.out.println(now);
        String customTime = "12:30:45";
        LocalTime parse = LocalTime.parse(customTime);
        System.out.println(parse);

        ZonedDateTime now1 = ZonedDateTime.now();
        System.out.println(now1);

        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);

        long l = System.currentTimeMillis();
        System.out.println(l);
        Instant now2 = Instant.now();
        System.out.println(now2);
    }
}
