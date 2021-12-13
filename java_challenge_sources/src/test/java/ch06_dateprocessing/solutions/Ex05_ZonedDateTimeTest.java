package ch06_dateprocessing.solutions;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex05_ZonedDateTimeTest
{
    @Test
    public void testCalcArrival() throws Exception
    {
        // ARRANGE
        ZonedDateTime departure = ZonedDateTime.of(LocalDate.of(2019, 9, 15), LocalTime.of(13, 10),
                                                   ZoneId.of("Europe/Zurich"));

        Duration flightDuration = Duration.ofHours(11).plusMinutes(50);

        ZonedDateTime expected1 = ZonedDateTime.parse("2019-09-16T01:00+02:00[Europe/Zurich]");
        ZonedDateTime expected2 = ZonedDateTime.parse("2019-09-15T16:00-07:00" + "[America/Los_Angeles]");
        final ZonedDateTime departureTime = departure;
        final Duration flightDuration1 = flightDuration;

        // ACT
        ZonedDateTime arrival1 = departureTime.plus(flightDuration1);
        final ZonedDateTime arrival11 = arrival1;
        final ZoneId zoneAmerica = ZoneId.of("America/Los_Angeles");
        final ZonedDateTime arrival21 = arrival11.withZoneSameInstant(zoneAmerica);
        ZonedDateTime arrival2 = arrival21;

        // ASSERT
        assertAll(() -> assertEquals(expected1, arrival1), () -> assertEquals(expected2, arrival2));
    }
}
