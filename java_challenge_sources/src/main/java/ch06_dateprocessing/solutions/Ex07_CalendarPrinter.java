package ch06_dateprocessing.solutions;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Map;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex07_CalendarPrinter
{
    private Ex07_CalendarPrinter()
    {
    }

    public static void main(final String[] args)
    {
        final Map<Month, Integer> monthYearMapping = Map.of(Month.JUNE, 2020, // starts on a Monday
                                                            Month.MAY, 2020, // ends on a Sunday
                                                            Month.APRIL, 2020); // starts Wed, ends Thu

        monthYearMapping.forEach((month, year) -> {
            System.out.println(month + " " + year);

            printCalendar(month, year);

            System.out.println();
        });

        final DayOfWeek currentWeekDay = DayOfWeek.MONDAY;
        System.out.println(currentWeekDay.plus(10));
    }

    static void printCalendar(final Month month, final int year)
    {
        System.out.println("Mon Tue Wed Thu Fri Sat Sun ");

        final LocalDate cur = LocalDate.of(year, month, 1);
        final DayOfWeek firstInMonth = cur.getDayOfWeek();

        skipTillFirstDayOfMonth(firstInMonth);

        DayOfWeek currentWeekDay = firstInMonth;
        final int lengthOfMonth = month.length(Year.of(year).isLeap());
        for (int i = 1; i <= lengthOfMonth; i++)
        {
            System.out.print(String.format("%3d", i) + " ");
            if (currentWeekDay == DayOfWeek.SUNDAY)
                System.out.println();

            currentWeekDay = nextWeekDay(currentWeekDay);
        }

        fillFromMonthEndToSunday(currentWeekDay);

        // last day not Sunday, then line wrap
        if (currentWeekDay != DayOfWeek.MONDAY)
            System.out.println();
    }

    static void skipTillFirstDayOfMonth(final DayOfWeek firstInMonth)
    {
        DayOfWeek currentWeekDay = DayOfWeek.MONDAY;
        while (currentWeekDay != firstInMonth)
        {
            System.out.print("... ");
            currentWeekDay = nextWeekDay(currentWeekDay);
        }
    }

    static void fillFromMonthEndToSunday(final DayOfWeek currentWeekDay)
    {
        DayOfWeek nextWeekDay = currentWeekDay;
        while (nextWeekDay != DayOfWeek.MONDAY)
        {
            System.out.print("--- ");
            nextWeekDay = nextWeekDay(nextWeekDay);
        }
    }

    static DayOfWeek nextWeekDay(final DayOfWeek currentWeekDay)
    {
        return currentWeekDay.plus(1);
    }
}
