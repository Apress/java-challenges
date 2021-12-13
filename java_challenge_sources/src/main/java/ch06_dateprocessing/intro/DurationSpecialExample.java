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
public class DurationSpecialExample
{
    public static void main(final String[] args)
    {
        // creation
        final Instant christmas2013 = Instant.parse("2013-12-24T00:00:00Z");
        final Instant silvester2013 = Instant.parse("2013-12-31T00:00:00Z");

        // Attention: Duration does not provide ofWeeks(long) or ofMonths(long)
        final Instant silvester_OneWeek = christmas2013.plus(1, ChronoUnit.WEEKS);
        System.out.println(silvester_OneWeek);
    }
}
