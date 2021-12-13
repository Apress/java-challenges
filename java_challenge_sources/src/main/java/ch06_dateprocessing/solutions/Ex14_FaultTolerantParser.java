package ch06_dateprocessing.solutions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex14_FaultTolerantParser
{
    private Ex14_FaultTolerantParser()
    {
    }

    public static void main(final String[] args)
    {
        final Set<DateTimeFormatter> formatters = populateFormatters();

        System.out.println("Fault tolerant parse:\n");
        final List<String> exampleDates = List.of("07.02.71", "07.02.1971",
                                                  "02/07/1971", "1971-02-07",
                                                  "31-01-1940", "1940/01/31");

        for (final String dateAsString : exampleDates)
        {
            final Optional<LocalDate> optParsedLocalDate =
                            faultTolerantParse(dateAsString, formatters);
            optParsedLocalDate.ifPresentOrElse(
                                               parsed -> System.out.println("Parsed '" + dateAsString + " into " + parsed + "'"),
                                               () ->  System.out.println("unable to parse " + dateAsString));
        }
    }

    static Optional<LocalDate> faultTolerantParse(final CharSequence input,
                                                  final Set<DateTimeFormatter> formatters)
    {
        LocalDate result = null;

        final var it = formatters.iterator();
        while (result == null && it.hasNext())
        {
            final var entry = it.next();
            try
            {
                result = LocalDate.parse(input, entry);
            }
            catch (final DateTimeParseException ignore)
            {
                // try next
            }
        }

        return Optional.ofNullable(result);
    }

    static Set<DateTimeFormatter> populateFormatters()
    {
        final Set<DateTimeFormatter> formatters = new LinkedHashSet<>();
        formatters.add(DateTimeFormatter.ofPattern("dd.MM.yy"));
        formatters.add(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        formatters.add(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        formatters.add(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return formatters;
    }
}
