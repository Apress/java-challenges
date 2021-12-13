package ch06_dateprocessing.solutions;

import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.IsoFields;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex10_FirstDayOfQuarter implements TemporalAdjuster
{
    private static final Month[] startMonthOfQuarter = { Month.JANUARY,
                                                         Month.APRIL,
                                                         Month.JULY,
                                                         Month.OCTOBER };

    @Override
    public Temporal adjustInto(final Temporal temporal)
    {
        final int currentQuarter = getQuarter(temporal);

        final Month startMonth = startMonthOfQuarter[currentQuarter - 1];

        return LocalDate.from(temporal).
                        withMonth(startMonth.getValue()).
                        with(firstDayOfMonth());
    }

    private int getQuarter(final Temporal temporal)
    {
        return (int)Month.from(temporal).
                        getLong(IsoFields.QUARTER_OF_YEAR);
    }
}