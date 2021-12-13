package ch06_dateprocessing.intro;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class LocalDateAndTimeExample
{
    public static void main(final String[] args)
    {
        final LocalDate michasBirthday = LocalDate.of(1971, Month.FEBRUARY, 7);
        final LocalDate barbarasBirthday = michasBirthday.plusDays(17).
                        plusMonths(1).
                        plusYears(2);
        final LocalDate lastDayInFebruary = michasBirthday.with(TemporalAdjusters.lastDayOfMonth());

        System.out.println("michasBirthday:    " + michasBirthday);
        System.out.println("barbarasBirthday:  " + barbarasBirthday);
        System.out.println("lastDayInFebruary: " + lastDayInFebruary);

        final LocalTime atTen = LocalTime.of(10,00,00);
        final LocalTime tenFifteen = atTen.plusMinutes(15);
        final LocalTime breakfastTime = tenFifteen.minusHours(2);

        System.out.println("\natTen:             " + atTen);
        System.out.println("tenFifteen:        " + tenFifteen);
        System.out.println("breakfastTime:     " + breakfastTime);

        System.out.println("\nDay Of Week:  " + michasBirthday.getDayOfWeek());
        System.out.println("Day Of Month: " + michasBirthday.getDayOfMonth());
        System.out.println("Day Of Year:  " + michasBirthday.getDayOfYear());

        System.out.println("\nDay Of Week:  " + barbarasBirthday.getDayOfWeek());
        System.out.println("Day Of Month: " + barbarasBirthday.getDayOfMonth());
        System.out.println("Day Of Year:  " + barbarasBirthday.getDayOfYear());

        final LocalDateTime jdk8Release = LocalDateTime.of(2014, 3, 18, 8, 30);
        System.out.println("\njdk8Release:  " + jdk8Release);
        System.out.printf("jdk8Release:  %s.%s.%s\n", jdk8Release.getDayOfMonth(),
                          jdk8Release.getMonthValue(),
                          jdk8Release.getYear());
    }
}
