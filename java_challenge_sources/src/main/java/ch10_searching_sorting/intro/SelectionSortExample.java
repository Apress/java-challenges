package ch10_searching_sorting.intro;

import java.util.Arrays;

import ch05_arrays.util.ArrayUtils;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class SelectionSortExample
{
    private SelectionSortExample()
    {
    }

    public static void main(final String[] args)
    {
        final int[] values1 = { 4, 2, 7, 9, 1 };

        System.out.println(Arrays.toString(selectionsortMin(values1)));

        final int[] values2 = { 4, 2, 7, 9, 1 };

        System.out.println(Arrays.toString(selectionsortMinOpt(values2)));

        final int[] values3 = { 4, 2, 7, 9, 1, 111 };

        System.out.println(Arrays.toString(selectionSortMinReadable(values3)));

    }

    public static int[] selectionsortMin(final int[] values)
    {
        for (int i = 0; i < values.length - 1; i++)
        {
            int minIdx = i;

            // find min
            for (int j = i + 1; j < values.length; j++)
            {
                if (values[j] < values[minIdx])
                {
                    minIdx = j;
                }
            }

            final int tmp = values[minIdx];
            values[minIdx] = values[i];
            values[i] = tmp;

            System.out.println("Step " + i + " / array= " + Arrays.toString(values));
        }

        return values;
    }

    public static int[] selectionsortMinOpt(int[] values)
    {
        for (int i = 0; i < values.length - 1; i++)
        {
            final int minIdx = ArrayUtils.findMinPos(values, i, values.length);

            ArrayUtils.swap(values, minIdx, i);

            System.out.println("Step " + i + " / array= " + Arrays.toString(values));
        }

        return values;
    }

    public static int[] selectionSortMinReadable(final int[] values)
    {
        for (int curIdx = 0; curIdx < values.length - 1; curIdx++)
        {
            final int minIdx = ArrayUtils.findMinPos(values, curIdx, values.length);

            ArrayUtils.swap(values, minIdx, curIdx);
        }

        return values;
    }
}
