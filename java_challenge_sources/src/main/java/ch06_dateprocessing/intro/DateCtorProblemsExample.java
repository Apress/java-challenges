package ch06_dateprocessing.intro;

import java.util.Date;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class DateCtorProblemsExample
{
    public static void main(final String[] args)
    {
        // birthday of the author: 2/7/1971
        final int year = 1971;
        final int month = 2;
        final int day = 7;

        System.out.println(new Date(year, month, day));
        System.out.println(new Date(year - 1900, month - 1, day));
    }
}