package ch06_dateprocessing.intro;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class TemporalAdjustersExample
{
    public static void main(final String[] args)
    {
        final LocalDate michasBirthday = LocalDate.of(1971, Month.FEBRUARY, 7);

        var firstDayInFebruary =
                        michasBirthday.with(TemporalAdjusters.firstDayOfMonth());
        var lastDayInFebruary =
                        michasBirthday.with(TemporalAdjusters.lastDayOfMonth());
        var previousMonday =
                        michasBirthday.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        var nextFriday =
                        michasBirthday.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));

        System.out.println("michasBirthday:     " + michasBirthday);
        System.out.println("firstDayInFebruary: " + firstDayInFebruary);
        System.out.println("lastDayInFebruary:  " + lastDayInFebruary);
        System.out.println("previousMonday:     " + previousMonday);
        System.out.println("nextFriday:         " + nextFriday);
    }
}
