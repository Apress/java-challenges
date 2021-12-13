package ch06_dateprocessing.intro;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class ZoneIdExample
{
    public static void main(final String[] args)
    {
        final Stream<String> zoneIdNames = Stream.of("Africa/Nairobi", "Europe/Zurich", "America/Los_Angeles");

        zoneIdNames.forEach(zoneIdName -> {
            final ZoneId zoneId = ZoneId.of(zoneIdName);
            var someDay = ZonedDateTime.of(LocalDate.parse("2020-04-05"), LocalTime.parse("17:30:15"), zoneId);

            System.out.println(zoneIdName + ": " + someDay);
        });

        final Set<String> allZones = ZoneId.getAvailableZoneIds();
        final Predicate<String> inEurope = name -> name.startsWith("Europe/");
        final List<String> threeFromEurope = allZones.stream().filter(inEurope).limit(3).collect(Collectors.toList());

        System.out.println("\nSome timezones in europe:");
        threeFromEurope.forEach(System.out::println);
    }
}
