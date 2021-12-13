package ch06_dateprocessing.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex12_NextPaydayAdjusterTest
{
    @ParameterizedTest(name = "adjustToPayday({0}) => {1}, {2}")
    @CsvSource(value = { "2019-07-21; 2019-07-25; normal adjustment",
                         "2019-06-27; 2019-07-25; normal adjustment, next month",
                         "2019-08-21; 2019-08-23; Friday, if 25th in weekend",
                         "2019-12-06; 2019-12-16; December: mid of month, Monday after weekend",
    "2019-12-23; 2020-01-24; next month and Friday if 25th on weekend" }, delimiterString = ";")
    public void adjustInto(LocalDate startDay, LocalDate expected, String info)
    {
        final TemporalAdjuster paydayAdjuster = new Ex12_NextPaydayAdjuster();

        final Temporal result = paydayAdjuster.adjustInto(startDay);

        assertEquals(expected, result);
    }
}
