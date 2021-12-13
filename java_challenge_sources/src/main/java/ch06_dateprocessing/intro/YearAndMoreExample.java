package ch06_dateprocessing.intro;

import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class YearAndMoreExample
{
    public static void main(final String[] args)
    {
        final int dayOfBirthday = 7;
        final MonthDay monthDay1 = MonthDay.of(2, dayOfBirthday);
        final MonthDay february7th = MonthDay.of(Month.FEBRUARY, dayOfBirthday);

        // YearMonth
        final YearMonth yearMonth = YearMonth.of(2014, 2);
        final YearMonth february2014 = YearMonth.of(2014, Month.FEBRUARY);

        // Year
        final Year year = Year.of(2012);
        final boolean isLeapYear = year.isLeap();

        System.out.println("MonthDay:  " + february7th);
        System.out.println("YearMonth: " + february2014);
        System.out.println("Year:      " + year + " / isLeap? " + isLeapYear);
    }
}