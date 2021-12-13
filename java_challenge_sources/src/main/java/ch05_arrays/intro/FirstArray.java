package ch05_arrays.intro;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class FirstArray
{
    public static void main(final String[] args)
    {
        final char[] greeting = "Hello".toCharArray();
        printArray(greeting);
    }

    public static void printArray(final char[] values)
    {
        for (int i= 0; i < values.length; i++)
        {
            final char ch = values[i];
            System.out.println(ch);
        }
    }
}
