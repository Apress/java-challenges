package ch06_dateprocessing.intro;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class InstantExample
{
    public static void main(final String[] args)
    {
        // Departure now and travel time 5 hours
        final Instant departureTime = Instant.now();
        final Instant expectedArrivalTime = departureTime.plus(5, ChronoUnit.HOURS);

        // Calculate delay of 7 minutes in two different ways
        final Instant realArrival = expectedArrivalTime.plus(7, ChronoUnit.MINUTES);
        final Instant realArrival2 = expectedArrivalTime.plus(Duration.ofMinutes(7));

        System.out.println(departureTime);		    // 2014-03-22T13:54:50.818Z
        System.out.println(expectedArrivalTime); // 2014-03-22T18:54:50.818Z
        System.out.println(realArrival); // 2014-03-22T19:01:50.818Z
        System.out.println(realArrival2);			// 2014-03-22T19:01:50.818Z
    }
}