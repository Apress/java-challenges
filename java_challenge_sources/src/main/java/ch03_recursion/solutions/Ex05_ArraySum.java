package ch03_recursion.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex05_ArraySum
{
    private Ex05_ArraySum()
    {
    }

    static int sum(final int[] values)
    {
        return sum(values, 0);
    }

    static int sum(final int[] values, final int pos)
    {
        if (pos >= values.length)
            return 0;

        int value = values[pos];
        return value + sum(values, pos + 1);
    }

    static int sumV2(final int[] values)
    {
        return sumV2(values, values.length - 1);
    }

    static int sumV2(final int[] values, final int pos)
    {
        if (pos < 0)
            return 0;

        int value = values[pos];
        return sumV2(values, pos - 1) + value;
    }
}