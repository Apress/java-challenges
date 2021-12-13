package ch06_dateprocessing.intro;

import static java.time.format.DateTimeFormatter.ofPattern;
import static java.time.format.FormatStyle.SHORT;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class FormattingAndParsingExample
{
    public static void main(final String[] args)
    {
        // Definition of some special formatters
        final DateTimeFormatter ddMMyyyyFormat = ofPattern("dd.MM.yyyy");
        final DateTimeFormatter italian_dMMMMyy = ofPattern("d.MMMM y", Locale.ITALIAN);
        final DateTimeFormatter shortGerman = DateTimeFormatter.ofLocalizedDate(SHORT).withLocale(Locale.GERMAN);

        // Attention: The textual parts are to be enclosed in quotation marks
        final String customPattern = "'Der 'dd'. Tag im 'MMMM' im Jahr 'yy'.'";
        final DateTimeFormatter customFormat = ofPattern(customPattern);

        System.out.println("Formatting:\n");
        final LocalDate february7th = LocalDate.of(1971, 2, 7);

        System.out.println("ddMMyyyyFormat: " + ddMMyyyyFormat.format(february7th));
        System.out.println("italian_dMMMMy: " + italian_dMMMMyy.format(february7th));
        System.out.println("shortGerman:    " + shortGerman.format(february7th));
        System.out.println("customFormat:   " + customFormat.format(february7th));

        // Parsing of date values
        System.out.println("\nParsing:\n");

        final LocalDate fromIsoDate = LocalDate.parse("1971-02-07");
        final LocalDate fromddMMyyyyFormat = LocalDate.parse("18.03.2014", ddMMyyyyFormat);
        final LocalDate fromShortGerman = LocalDate.parse("18.03.14", shortGerman);
        final LocalDate fromCustomFormat = LocalDate.parse("Der 31. Tag im Dezember im Jahr 19.", customFormat);

        System.out.println("From ISO Date:       " + fromIsoDate);
        System.out.println("From ddMMyyyyFormat: " + fromddMMyyyyFormat);
        System.out.println("From short german:   " + fromShortGerman);
        System.out.println("From custom format:  " + fromCustomFormat);
    }
}