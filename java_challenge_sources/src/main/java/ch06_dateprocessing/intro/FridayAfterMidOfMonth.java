package ch06_dateprocessing.intro;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class FridayAfterMidOfMonth implements TemporalAdjuster
{
    @Override
    public Temporal adjustInto(final Temporal temporal)
    {
        final LocalDate startday = LocalDate.from(temporal);

        final int dayOfMonth = startday.getMonth() == Month.FEBRUARY ? 14 : 15;

        return startday.withDayOfMonth(dayOfMonth).
                        with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
    }
}
