package ch05_arrays.intro;

import java.util.Random;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class RandomExample
{
    public static void main(final String[] args)
    {
        final Random random = new Random();

        // Integer random number between 0 (inclusive) and 10 (exclusive)
        final int randomNumberInt = random.nextInt(10);

        final double randomNumberDouble = random.nextDouble();

        System.out.println(randomNumberInt);
        System.out.println(randomNumberDouble);
    }
}
