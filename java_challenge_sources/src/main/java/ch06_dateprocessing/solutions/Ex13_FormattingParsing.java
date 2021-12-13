package ch06_dateprocessing.solutions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex13_FormattingParsing
{
    private Ex13_FormattingParsing()
    {
    }

    public static void main(final String[] args)
    {
        final LocalDateTime jdk9Release = LocalDateTime.of(2017, 7, 27, 13, 14, 15);

        final var formatter1 = DateTimeFormatter.ofPattern("dd MM yyyy HH");
        final var formatter2 = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
        final var formatter3 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        final var formatter4 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT,
                                                                     FormatStyle.SHORT)
                        .withLocale(Locale.US);

        applyFormatters(jdk9Release, List.of(formatter1, formatter2,
                                             formatter3, formatter4));
    }

    static void applyFormatters(final LocalDateTime base,
                                final List<DateTimeFormatter> formatters)
    {
        formatters.forEach((formatter) -> {

            final var formatted = base.format(formatter);

            try
            {
                // Caution: Pitfall
                //LocalDateTime parsed = formatter.parse(formatted);
                final LocalDateTime parsed = LocalDateTime.parse(formatted, formatter);
                System.out.println("Formatted: " + formatted + " / Parsed: " + parsed);
            }
            catch (final DateTimeParseException ignore)
            {

            }
        });
    }
}