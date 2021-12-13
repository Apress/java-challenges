package ch06_dateprocessing.intro;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class ChronoUnitExample
{
    public static void main(final String[] args)
    {
        final Instant departureTime = Instant.now();
        System.out.println("departure now:    " + departureTime);

        final Instant arrivalTime = departureTime.plus(5, ChronoUnit.HOURS);
        System.out.println("arrival now + 5h: " + arrivalTime);

        // perform calculations
        final long inBetweenHours = ChronoUnit.HOURS.between(departureTime,
                                                             arrivalTime);
        final long inBetweenMinutes = ChronoUnit.MINUTES.between(departureTime,
                                                                 arrivalTime);
        System.out.println("inBetweenHours:   " + inBetweenHours);
        System.out.println("inBetweenMinutes: " + inBetweenMinutes);
    }
}