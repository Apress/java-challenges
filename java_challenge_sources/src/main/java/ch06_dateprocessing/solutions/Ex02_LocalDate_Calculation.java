package ch06_dateprocessing.solutions;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex02_LocalDate_Calculation
{
    private Ex02_LocalDate_Calculation()
    {
    }

    public static void main(final String[] args)
    {
        ex2a();

        ex2b();
    }

    private static void ex2a()
    {
        final LocalDate myBirthday = LocalDate.of(1971, 2, 7);
        final LocalTime time = LocalTime.of(17, 30);
        final LocalDateTime now = LocalDateTime.now();

        System.out.println(myBirthday);
        System.out.println(time);
        System.out.println(now);


        final Period oneYear10Mont203Days = Period.of(1, 10, 20);
        final Duration sevenHours15Minutes = Duration.ofHours(7).plusMinutes(15);
        System.out.println(oneYear10Mont203Days);
        System.out.println(sevenHours15Minutes);
    }

    private static void ex2b()
    {
        final LocalDate now = LocalDate.now();
        final LocalDate birthday = LocalDate.of(1971, 2, 7);

        System.out.println("Using until()");
        System.out.println("now -> birthday: " + now.until(birthday));
        System.out.println("birthday -> now: " + birthday.until(now));
        System.out.println();
        System.out.println("Using Period.between()");
        System.out.println("now -> birthday: " + Period.between(now, birthday));
        System.out.println("birthday -> now: " + Period.between(birthday, now));
    }
}
