package ch06_dateprocessing.solutions;

import java.time.LocalDate;
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
public class Ex10_FirstDayOfQuarterOptimized implements TemporalAdjuster
{
    @Override
    public Temporal adjustInto(final Temporal temporal)
    {
        return LocalDate.from(temporal).with(IsoFields.DAY_OF_QUARTER, 1);
    }
}