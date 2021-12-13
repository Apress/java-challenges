package ch06_dateprocessing.solutions;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex08_WeekDays
{
    private Ex08_WeekDays()
    {
    }

    public static void main(final String[] args)
    {
        final LocalDate christmasEve = LocalDate.of(2019, 12, 24);
        System.out.println("24. Dez. 2019 = " + christmasEve.getDayOfWeek());
        System.out.println("24. Dez. 2019 = " + DayOfWeek.from(christmasEve));

        final var decemberFirst = christmasEve.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("01. Dez. 2019 = " + decemberFirst.getDayOfWeek());

        final var decemberLast = christmasEve.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("31. Dez. 2019 = " + decemberLast.getDayOfWeek());

        // b)
        final YearMonth march2019 = YearMonth.of(2019, Month.MARCH);
        final var results = firstAndLastFridayAndSunday(march2019);
        System.out.println(results);

        // c)
        dayOfMonthAndDayInYear(results);
    }

    static Map<String, LocalDate> firstAndLastFridayAndSunday(final YearMonth yearMonth)
    {
        final TemporalAdjuster toFirstSunday = TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY);
        final TemporalAdjuster toLastSunday = TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY);
        final TemporalAdjuster toFirstFriday = TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY);
        final TemporalAdjuster toLastFriday = TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY);

        final LocalDate day = LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), 15);
        return new TreeMap<>(Map.of("firstSunday", day.with(toFirstSunday),
                                    "lastSunday", day.with(toLastSunday),
                                    "firstFriday", day.with(toFirstFriday),
                                    "lastFriday", day.with(toLastFriday)));
    }

    static void dayOfMonthAndDayInYear(final Map<String, LocalDate> days)
    {
        System.out.println("Day           Of Month / Of Year");

        for (final String key : List.of("firstFriday", "firstSunday",
                                        "lastFriday", "lastSunday"))
        {
            final LocalDate day = days.getOrDefault(key, LocalDate.now());

            System.out.println(String.format("%-12s %9d %9d",
                                             key,
                                             day.getDayOfMonth(),
                                             day.getDayOfYear()));
        }
    }
}
