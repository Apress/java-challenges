package ch06_dateprocessing.intro;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class DateToLocalDateExample
{
    public static void main(String[] args)
    {
        // Conversions from ZonedDateTime -> Date
        final ZonedDateTime nowZdt = ZonedDateTime.now();
        final Date nowAsDate1 = Date.from(nowZdt.toInstant());
        System.out.println("From ZonedDateTime:      " + nowAsDate1);

        // Conversions from LocalDateTime -> Date
        final LocalDateTime startLdt = LocalDateTime.parse("2015-05-09T16:27:38");

        // Variant 2 with conversion first to ZonedDateTime per atZone()
        final ZonedDateTime zdt = startLdt.atZone(ZoneId.systemDefault());
        final Date nowAsDate2 = Date.from(zdt.toInstant());
        System.out.println("From LocalDateTime V2:   " + nowAsDate2);

        // Variant 3 with ZoneOffset
        final Date nowAsDate3 = Date.from(startLdt.toInstant(zdt.getOffset()));
        System.out.println("From LocalDateTime V3:   " + nowAsDate3);

        // Conversions from Date -> LocalDateTime etc.
        final Instant instant = Instant.ofEpochMilli(nowAsDate3.getTime());
        final LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println("LocalDateTime from Date: " + ldt);

        // Conversion to LocalDate or LocalTime
        final LocalDate ld = ldt.toLocalDate();
        System.out.println("LocalDate:               " + ld);
        final LocalTime lt = ldt.toLocalTime();
        System.out.println("LocalTime:               " + lt);
    }
}
