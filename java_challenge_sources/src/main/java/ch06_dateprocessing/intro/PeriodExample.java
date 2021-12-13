package ch06_dateprocessing.intro;

import java.time.Period;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class PeriodExample
{
    public static void main(final String[] args)
    {
        // Create a Period object with 1 year, 6 months and 3 days
        final Period oneYear_sixMonths_ThreeDays = Period.ofYears(1).withMonths(6).
                        withDays(3);

        Period.ofMonths(2);
        Period.ofWeeks(1);
        // Chaining of() works differently than you might expect!
        // Here a Period object with 3 days instead of 2 months, 1 week and 3 days.
        final Period twoMonths_OneWeek_ThreeDays = Period.
                        ofDays(3);

        final Period twoMonths_TenDays = Period.ofMonths(2).withDays(10);
        final Period sevenWeeks = Period.ofWeeks(7);
        final Period threeDays = Period.ofDays(3);

        System.out.println("1 year 6 months ...:  " + oneYear_sixMonths_ThreeDays);
        System.out.println("Surprise just 3 days: " + twoMonths_OneWeek_ThreeDays);
        System.out.println("2 months 10 days:     " + twoMonths_TenDays);
        System.out.println("sevenWeeks:           " + sevenWeeks);
        System.out.println("threeDays:            " + threeDays);
    }
}