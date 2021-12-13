package ch06_dateprocessing.intro;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class NewApiDurationCalculationExample
{
    public static void main(String[] args) throws ParseException
    {
        // Difference 1 hour, 10 minute and 20 seconds
        final String startTimeAsString = "10:10:10";
        final String endTimeAsString  = "11:20:30";

        // Conversion to LocalTime objects
        final LocalTime startTime = LocalTime.parse(startTimeAsString);
        final LocalTime endTime = LocalTime.parse(endTimeAsString);

        // Calculate difference as duration and in seconds
        final Duration duration = Duration.between(startTime, endTime);
        final long durationInSecs = duration.getSeconds();

        System.out.println("duration = " + duration + " in secs = " + durationInSecs);

        // Conversion to LocalTime and output
        final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        final LocalTime durationAsLocalTime = LocalTime.ofSecondOfDay(durationInSecs);
        System.out.println("durationInHHmmss = " + dateFormat.format(durationAsLocalTime));
    }
}