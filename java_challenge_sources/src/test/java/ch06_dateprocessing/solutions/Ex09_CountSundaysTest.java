package ch06_dateprocessing.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex09_CountSundaysTest
{
    @ParameterizedTest(name = "allSundaysBetween({0}, {1}) => {2}")
    @CsvSource({ "2017-01-01, 2018-01-01, 53", "2019-01-01, 2019-02-07, 5" })
    public void allSundaysBetween(final LocalDate start, final LocalDate end, final int expected)
    {
        final var result = Ex09_CountSundays.allSundaysBetween(start, end);

        assertEquals(expected, result.count());
    }

    @ParameterizedTest(name = "allBetween({0}, {1}, {2}) => {3}")
    @CsvSource({ "SUNDAY, 2017-01-01, 2018-01-01, 53", "SUNDAY, 2019-01-01, 2019-02-07, 5" })
    public void testAllBetween(final DayOfWeek dayOfWeek, final LocalDate start, final LocalDate end,
                               final int expected)
    {
        final var result = Ex09_CountSundays.allBetween(dayOfWeek, start, end);

        assertEquals(expected, result.count());
    }

    @ParameterizedTest(name = "countLeepYears({0}, {1}) => {2}")
    @CsvSource({ "2010, 2019, 2", "2000, 2019, 5" })
    void countLeapYears(final Year start, final Year end, final int expected)
    {
        final long result = Ex09_CountSundays.countLeapYears(start, end);

        assertEquals(expected, result);
    }

    @Test
    public void testCountLeapYearsSimple()
    {
        final long result = Ex09_CountSundays.countLeapYears(Year.of(2010), Year.of(2019));

        assertEquals(2, result);
    }

    @ParameterizedTest(name = "countLeepYears({0}, {1}) => {2}")
    @CsvSource({ "2010, 2019, 2", "2000, 2019, 5" })
    String countLeepYears(final Year start, final Year end, final int expected)
    {
        final long result = Ex09_CountSundays.countLeapYears(start, end);

        assertEquals(expected, result);

        return "";
    }

    @ParameterizedTest(name = "countLeapYears2({0}, {1}) => {2}")
    @CsvSource({ "2010, 2019, 2", "2000, 2019, 5" })
    String countLeapYears2(final Year start, final Year end, final int expected)
    {
        final long result = Ex09_CountSundays.countLeapYears2(start, end);

        assertEquals(expected, result);

        return "";
    }
}
