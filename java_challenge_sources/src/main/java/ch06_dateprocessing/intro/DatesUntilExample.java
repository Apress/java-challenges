package ch06_dateprocessing.intro;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.stream.Stream;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class DatesUntilExample
{
    public static void main(final String[] args)
    {
        final LocalDate myBirthday = LocalDate.of(1971, Month.FEBRUARY, 7);
        final LocalDate christmas = LocalDate.of(1971, Month.DECEMBER, 24);

        System.out.println("Day-Stream");
        final Stream<LocalDate> daysUntil = myBirthday.datesUntil(christmas);
        daysUntil.skip(150).limit(4).forEach(System.out::println);

        System.out.println("\n3-Month-Stream");
        final Stream<LocalDate> monthsUntil =
                        myBirthday.datesUntil(christmas, Period.ofMonths(3));
        monthsUntil.limit(3).forEach(System.out::println);
    }
}

