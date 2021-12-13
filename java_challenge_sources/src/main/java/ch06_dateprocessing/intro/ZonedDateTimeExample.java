package ch06_dateprocessing.intro;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class ZonedDateTimeExample
{
    public static void main(final String[] args)
    {
        // Get current time as ZonedDateTime object
        final ZonedDateTime someDay = ZonedDateTime.of(LocalDate.parse("2020-02-07"),
                                                       LocalTime.parse("17:30:15"),
                                                       ZoneId.of("Europe/Zurich"));

        // Change the time and save it in a new object
        final ZonedDateTime someDayChangedTime = someDay.withHour(11).withMinute(44);

        // Create new object with changed date
        final ZonedDateTime dateAndTime = someDayChangedTime.withYear(2008).
                        withMonth(9).
                        withDayOfMonth(29);

        // Use a month constant and change the time zone
        final ZonedDateTime dateAndTime2 = someDayChangedTime.withYear(2008).
                        withMonth(Month.SEPTEMBER.getValue()).
                        withDayOfMonth(29).
                        withZoneSameInstant(ZoneId.of("GMT"));

        System.out.println("someDay:      " + someDay);
        System.out.println("-> 11:44:     " + someDayChangedTime);
        System.out.println("-> 29.9.2008: " + dateAndTime);
        System.out.println("-> 29.9.2008: " + dateAndTime2);
    }
}