package ch05_arrays.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex12_ArraysMinMax
{
    private Ex12_ArraysMinMax()
    {
    }

    public static int findMin(final int[] values)
    {
        if (values.length == 0)
            throw new IllegalArgumentException("values must not be empty");

        int min = values[0];
        for (int i = 1; i < values.length; i++)
        {
            if (values[i] < min)
            {
                min = values[i];
            }
        }
        return min;
    }

    public static int findMax(final int[] values)
    {
        if (values.length == 0)
            throw new IllegalArgumentException("values must not be empty");

        int max = values[0];
        for (int i = 1; i < values.length; i++)
        {
            if (values[i] > max)
            {
                max = values[i];
            }
        }
        return max;
    }

    public static int findMinPos(final int[] values, final int startPos, final int endPos)
    {
        int minPos = startPos;
        for (int i = startPos + 1; i < endPos; i++)
        {
            if (values[i] < values[minPos])
            {
                minPos = i;
            }
        }
        return minPos;
    }


    public static int findMaxPos(final int[] values, final int startPos, final int endPos)
    {
        int maxPos = startPos;
        for (int i = startPos + 1; i < endPos; i++)
        {
            if (values[i] > values[maxPos])
            {
                maxPos = i;
            }
        }
        return maxPos;
    }

    public static int findMinByPos(final int[] values, final int start, final int endExclisive)
    {
        final int minPos = findMinPos(values, start, endExclisive);

        return values[minPos];
    }

    public static int findMaxByPos(final int[] values)
    {
        final int maxPos = findMaxPos(values, 0, values.length);

        return values[maxPos];
    }

    public static int findMinByPos(final int[] values)
    {
        final int minPos = findMinPos(values, 0, values.length);

        return values[minPos];
    }

    public static int findMaxByPos(final int[] values, final int start, final int endExclisive)
    {
        final int maxPos = findMaxPos(values, start, endExclisive);

        return values[maxPos];
    }
}
