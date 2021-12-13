package ch10_searching_sorting.solutions;

import java.util.Arrays;

import ch05_arrays.util.ArrayUtils;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex05_SelectionSort
{
    private Ex05_SelectionSort()
    {
    }

    public static void selectionSortMaxInplace(final int[] values)
    {
        for (int i = values.length - 1; i > 0 ; i--)
        {
            final int maxPos = ArrayUtils.findMaxPos(values, 0, i + 1);

            ArrayUtils.swap(values, maxPos, i);
        }
    }

    public static int[] selectionSortMaxCopy(final int[] values)
    {
        final int[] copy = Arrays.copyOf(values, values.length);
        selectionSortMaxInplace(copy);
        return copy;
    }
}
