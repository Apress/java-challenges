package ch06_dateprocessing.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex10_FirstDayOfQuarterTest
{
    @ParameterizedTest(name = "move {0} to first of quarter: {1}")
    @CsvSource({ "2014-03-15, 2014-01-01", "2014-06-16, 2014-04-01",
        "2014-09-15, 2014-07-01", "2014-11-15, 2014-10-01" })
    void adjustToFirstDayOfQuarter(LocalDate startDate, LocalDate expected)
    {
        var result = new Ex10_FirstDayOfQuarter().adjustInto(startDate);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "move {0} to first of quarter: {1}")
    @CsvSource({ "2014-03-15, 2014-01-01", "2014-06-16, 2014-04-01",
        "2014-09-15, 2014-07-01", "2014-11-15, 2014-10-01" })
    void adjustToFirstDayOfQuarterOptimized(LocalDate startDate, LocalDate expected)
    {
        var result = new Ex10_FirstDayOfQuarterOptimized().adjustInto(startDate);

        assertEquals(expected, result);
    }
}
