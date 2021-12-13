package ch06_dateprocessing.solutions;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex06_Friday13thExample
{
    private Ex06_Friday13thExample()
    {
    }

    static List<LocalDate> allFriday13th(final LocalDate start, final LocalDate end)
    {
        final Predicate<LocalDate> isFriday = day -> day.getDayOfWeek() ==
                        DayOfWeek.FRIDAY;
        final Predicate<LocalDate> is13th = day -> day.getDayOfMonth() == 13;

        final List<LocalDate> allFriday13th = start.datesUntil(end)
                        .filter(isFriday)
                        .filter(is13th)
                        .collect(Collectors.toList());
        return allFriday13th;
    }

    static Map<Integer, List<LocalDate>> friday13thGrouped(final LocalDate start,
                                                           final LocalDate end)
    {
        return new TreeMap<>(allFriday13th(start, end).stream().
                        collect(Collectors.groupingBy(LocalDate::getYear)));
    }
}
