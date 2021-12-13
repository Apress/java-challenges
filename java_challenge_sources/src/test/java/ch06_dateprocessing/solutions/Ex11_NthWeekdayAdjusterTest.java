package ch06_dateprocessing.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex11_NthWeekdayAdjusterTest
{
    @ParameterizedTest(name = "adjusting {0} to {1}. {2} => {3}")
    @CsvSource({ "2015-08-15, 2, FRIDAY, 2015-08-14",
        "2015-08-15, 3, SUNDAY, 2015-08-16",
    "2015-08-15, 4, TUESDAY, 2015-08-25" })
    void adjustToFirstDayOfQuarter(final LocalDate startDay, final int count,
                                   final DayOfWeek dayOfWeek, final LocalDate expected)
    {
        final var nthWeekdayAdjuster = new Ex11_NthWeekdayAdjuster(dayOfWeek, count);

        final Temporal result = nthWeekdayAdjuster.adjustInto(startDay);

        assertEquals(expected, result);
    }
}
