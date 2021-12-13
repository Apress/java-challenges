package ch06_dateprocessing.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex01_LeapYear
{
    private Ex01_LeapYear()
    {
    }

    static boolean isLeap(final int year)
    {
        final boolean everyFourthYear = year % 4 == 0;
        final boolean isSecular = year % 100 == 0;
        final boolean isSecularSpecial = year % 400 == 0;

        return everyFourthYear && (!isSecular || isSecularSpecial);
    }
}
