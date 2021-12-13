package ch06_dateprocessing.solutions;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex09_CountSundays
{
    private Ex09_CountSundays()
    {
    }

    static Stream<LocalDate> allSundaysBetween(final LocalDate start, final LocalDate end)
    {
        final Predicate<LocalDate> isSunday = day -> day.getDayOfWeek() == DayOfWeek.SUNDAY;

        return start.datesUntil(end).filter(isSunday);
    }

    static Stream<LocalDate> allBetween(final DayOfWeek dayOfWeek, final LocalDate start, final LocalDate end)
    {
        return start.datesUntil(end).filter(day -> day.getDayOfWeek() == dayOfWeek);
    }

    static long countLeapYears(final Year start, final Year end)
    {
        final LocalDate startDay = LocalDate.of(start.getValue(), 1, 1);
        final LocalDate endDay = LocalDate.of(end.getValue(), 1, 1);

        final Predicate<LocalDate> isLeapYear = localDate -> Year.isLeap(localDate.getYear());

        return startDay.datesUntil(endDay, Period.ofYears(1)).filter(isLeapYear).count();
    }

    static long countLeapYears2(final Year start, final Year end)
    {
        return IntStream.range(start.getValue(), end.getValue()).
                        filter(Year::isLeap).
                        count();
    }
}
