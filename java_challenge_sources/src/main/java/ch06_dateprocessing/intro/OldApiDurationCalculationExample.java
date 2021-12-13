package ch06_dateprocessing.intro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class OldApiDurationCalculationExample
{
    public static void main(final String[] args) throws ParseException
    {
        // Difference 1 hour, 10 minute and 20 seconds
        final String startTimeAsString = "10:10:10";
        final String endTimeAsString = "11:20:30";

        // Conversion to Date objects
        final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        final Date startTimee = dateFormat.parse(startTimeAsString);
        final Date endTime = dateFormat.parse(endTimeAsString);

        // Calculate difference based on milliseconds
        final long durationInMs = endTime.getTime() - startTimee.getTime();
        System.out.println("duration in seconds = " + TimeUnit.MILLISECONDS.toSeconds(durationInMs));

        final String duration1 = dateFormat.format(new Date(durationInMs));
        System.out.println("duration 1 = " + duration1);

        // Calculation must get time zone set
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        final String duration2 = dateFormat.format(new Date(durationInMs));
        System.out.println("duration2 = " + duration2);
    }
}