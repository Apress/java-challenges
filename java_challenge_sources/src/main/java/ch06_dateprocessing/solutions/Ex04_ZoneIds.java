package ch06_dateprocessing.solutions;

import java.time.ZoneId;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex04_ZoneIds
{
    private Ex04_ZoneIds()
    {
    }

    public static void main(final String[] args)
    {
        final Set<String> someEuropeAndAmericaZoneIds = selectedAmericanAndEuropeanTimeZones();
        System.out.println(someEuropeAndAmericaZoneIds);

        System.out.println("\nDesired timezones:");
        someEuropeAndAmericaZoneIds.forEach(System.out::println);
    }

    static Set<String> selectedAmericanAndEuropeanTimeZones()
    {
        final Set<String> allZones = ZoneId.getAvailableZoneIds();
        final Predicate<String> inEuropeS = name -> name.startsWith("Europe/S");
        final Predicate<String> inAmericaL = name -> name.startsWith("America/L");
        final Predicate<String> europeOrAmerica = inEuropeS.or(inAmericaL);

        return allZones.stream().filter(europeOrAmerica).collect(Collectors.toCollection(TreeSet::new));
    }
}
