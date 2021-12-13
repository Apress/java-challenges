package ch06_dateprocessing.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
public class Ex14_FaultTolerantFormattingTest
{
    @ParameterizedTest(name = "faultTolerantParse({0}) expected date {1}")
    @CsvSource({ "07.02.71, 2071-02-07", "07.02.1971, 1971-02-07",
        "02/07/1971, 1971-02-07", "1971-02-07, 1971-02-07" })
    public void testFaulttolerantparse(final String dateAsString, final LocalDate expected)
    {
        final var formatters = Ex14_FaultTolerantParser.populateFormatters();

        final var optParsedLocalDate =
                        Ex14_FaultTolerantParser.faultTolerantParse(dateAsString, formatters);

        assertTrue(optParsedLocalDate.isPresent());
        assertEquals(expected, optParsedLocalDate.get());
    }

    @ParameterizedTest(name = "faultTolerantParse({0}) expected empty")
    @CsvSource({ "31-01-1940", "1940/01/31" })
    public void testFaulttolerantparseInvalidFormats(final String dateAsString)
    {
        final var formatters = Ex14_FaultTolerantParser.populateFormatters();

        final var optParsedLocalDate =
                        Ex14_FaultTolerantParser.faultTolerantParse(dateAsString, formatters);

        assertTrue(optParsedLocalDate.isEmpty());
    }
}
