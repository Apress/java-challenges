package ch06_dateprocessing.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex08_WeekDaysTest
{
    @Test
    void testFirstAndLastFridayAndSunday()
    {
        final YearMonth march2019 = YearMonth.of(2019, Month.MARCH);

        var expected = Map.of("firstFriday", LocalDate.of(2019, 3, 1), "firstSunday", LocalDate.of(2019, 3, 3),
                              "lastFriday", LocalDate.of(2019, 3, 29), "lastSunday", LocalDate.of(2019, 3, 31));

        var result = Ex08_WeekDays.firstAndLastFridayAndSunday(march2019);

        assertEquals(expected, result);
    }
}
