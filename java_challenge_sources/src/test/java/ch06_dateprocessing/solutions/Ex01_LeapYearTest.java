package ch06_dateprocessing.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Year;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex01_LeapYearTest
{
    @ParameterizedTest(name = "isLeap({0} => {2}, hint: {1}")
    @CsvSource({ "1900, secular, false", "2000, secular (but 400 rule), true", "2020, every 4th year, true" })
    void testIsLeap(final int year, final String hint, final boolean expected)
    {
        final boolean result = Ex01_LeapYear.isLeap(year);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "isLeap({0} => {2}, hint: {1}")
    @CsvSource({ "1900, secular, false", "2000, secular (but 400 rule), true", "2020, every 4th year, true" })
    void testIsLeapJdk(final int year, final String hint, final boolean expected)
    {
        final boolean result = Year.isLeap(year);

        assertEquals(expected, result);
    }
}
