package ch06_dateprocessing.solutions;

import java.time.LocalDate;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex03_LengthOfMonth
{
    private Ex03_LengthOfMonth()
    {
    }

    public static void main(final String[] args)
    {
        final LocalDate february_2_2012 = LocalDate.of(2012, 2, 2);
        final LocalDate february_2_2014 = LocalDate.of(2014, 2, 2);
        final LocalDate april_4_2014 = LocalDate.of(2014, 4, 4);
        final LocalDate may_5_2014 = LocalDate.of(2014, 5, 5);

        // a)
        System.out.println("2.2.12 + 1 Monat = " + february_2_2012.plusMonths(1));
        System.out.println("2.2.14 + 1 Monat = " + february_2_2014.plusMonths(1));
        System.out.println("4.4.14 + 1 Monat = " + april_4_2014.plusMonths(1));
        System.out.println("5.5.14 + 1 Monat = " + may_5_2014.plusMonths(1));

        // b)
        System.out.println("2.2.12 + 28 Tage = " + february_2_2012.plusDays(28));
        System.out.println("2.2.14 + 28 Tage = " + february_2_2014.plusDays(28));
        System.out.println("4.4.14 + 30 Tage = " + april_4_2014.plusDays(30));
        System.out.println("5.5.14 + 31 Tage = " + may_5_2014.plusDays(31));
    }
}
