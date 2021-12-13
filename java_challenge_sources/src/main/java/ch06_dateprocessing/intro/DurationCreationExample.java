package ch06_dateprocessing.intro;

import java.time.Duration;
import java.time.Instant;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class DurationCreationExample
{
    public static void main(final String[] args)
    {
        // calculations
        final Instant now = Instant.now();
        final Instant silvester2013 = Instant.parse("2013-12-31T00:00:00Z");
        final Instant myBirthday2015 = Instant.parse("2015-02-07T00:00:00Z");
        final Duration duration1 = Duration.between(now, silvester2013);
        final Duration duration2 = Duration.between(silvester2013,
                                                    myBirthday2015);

        System.out.println(now + " -- " + silvester2013 + ": " + duration1);
        System.out.println(silvester2013 + " -- " + myBirthday2015 + ": " +
                        duration2);
    }
}
