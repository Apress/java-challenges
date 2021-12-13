package ch03_recursion.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex06_ArrayMin
{
    private Ex06_ArrayMin()
    {
    }

    static int min(final int[] values)
    {
        return min(values, 0, Integer.MAX_VALUE);
    }

    static int min(final int[] values, final int pos, int currentMin)
    {
        if (pos >= values.length)
            return currentMin;

        final int current = values[pos];
        if (current < currentMin)
            currentMin = current;

        return min(values, pos + 1, currentMin);
    }
}
