package ch06_dateprocessing.solutions;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex05_ZonedDateTime
{
    private Ex05_ZonedDateTime()
    {
    }

    public static void main(final String[] args)
    {
        final LocalDate departureDate = LocalDate.of(2019, 9, 15);
        final LocalTime departureTime = LocalTime.of(13, 10);
        final ZoneId zoneEurope = ZoneId.of("Europe/Zurich");
        final ZonedDateTime departure = ZonedDateTime.of(departureDate, departureTime, zoneEurope);

        // There is no withMinutes(), why not? API is otherwise very consistent
        final Duration flightDuration = Duration.ofHours(11).plusMinutes(50);

        // Calculate Arrival time based on European and American Time
        final ZonedDateTime arrival1 = departure.plus(flightDuration);
        final ZoneId zoneAmerica = ZoneId.of("America/Los_Angeles");
        final ZonedDateTime arrival2 = arrival1.withZoneSameInstant(zoneAmerica);

        System.out.println(arrival1);
        System.out.println(arrival2);
    }
}