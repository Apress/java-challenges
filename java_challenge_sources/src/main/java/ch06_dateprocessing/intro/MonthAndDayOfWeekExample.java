package ch06_dateprocessing.intro;

import java.time.DayOfWeek;
import java.time.Month;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class MonthAndDayOfWeekExample
{
    public static void main(final String[] args)
    {
        final DayOfWeek sunday = DayOfWeek.SUNDAY;
        final Month february = Month.FEBRUARY;

        final DayOfWeek friday = sunday.plus(5);
        final Month march = february.plus(13);

        System.out.println(friday);   // FRIDAY
        System.out.println(march); // MARCH
    }
}