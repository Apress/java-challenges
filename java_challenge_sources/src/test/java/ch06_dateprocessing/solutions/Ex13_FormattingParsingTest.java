package ch06_dateprocessing.solutions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex13_FormattingParsingTest
{
    @ParameterizedTest
    @CsvSource({"07.02.71, 2071-02-07", "07.02.1971, 1971-02-07",
        "02/07/1971, 1971-02-07", "1971-02-07, 1971-02-07"})
    public void testFaulttolerantparse(String dateAsString, LocalDate expected)
    {
        final LocalDateTime jdk9Release = LocalDateTime.of(2017, 7, 27, 13, 14, 15);

        var formatter1 = DateTimeFormatter.ofPattern("dd MM yyyy HH");
        var formatter2 = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
        var formatter3 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        var formatter4 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT,
                                                               FormatStyle.SHORT)
                        .withLocale(Locale.GERMAN);

        Ex13_FormattingParsing.
        applyFormatters(jdk9Release, List.of(formatter1, formatter2,
                                             formatter3, formatter4));
    }
}
