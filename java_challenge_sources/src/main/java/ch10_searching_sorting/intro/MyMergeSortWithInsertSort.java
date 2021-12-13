package ch10_searching_sorting.intro;

import java.util.Arrays;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class MyMergeSortWithInsertSort
{
    private MyMergeSortWithInsertSort()
    {
    }

    public static void main(final String[] args)
    {
        final int[] unsorted = { 7, 2, 6, 3, 4, 5, 8, 1, 9, 23, 34, 54, 72, 32, 44, 55, 11, 99, 72 };
        final int[] sorted = mergesort(unsorted);
        System.out.println(Arrays.toString(sorted));

        final int[] unsorted2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        final int[] sorted2 = mergesort(unsorted2);
        System.out.println(Arrays.toString(sorted2));

        final int[] unsorted3 = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        final int[] sorted3 = mergesort(unsorted3);
        System.out.println(Arrays.toString(sorted3));
    }

    static int[] mergesort(final int[] toSort)
    {
        // Mini-Optimization
        if (toSort.length < 5)
        {
            InsertionSortExample.insertionSort(toSort);
            return toSort;
        }

        final int midPos = toSort.length / 2;

        // divide again
        final int[] left = Arrays.copyOfRange(toSort, 0, midPos);
        final int[] resultLeft = mergesort(left);

        final int[] right = Arrays.copyOfRange(toSort, midPos, toSort.length);
        final int[] resultRight = mergesort(right);

        // merge
        return merge(resultLeft, resultRight);
    }

    private static int[] merge(final int[] first, final int[] second)
    {
        final int length1 = first.length;
        final int length2 = second.length;

        final int[] result = new int[length1 + length2];

        int pos1 = 0;
        int pos2 = 0;
        int idx = 0;

        // Continue until both position pointers are less than the length.
        while (pos1 < length1 && pos2 < length2)
        {
            final int value1 = first[pos1];
            final int value2 = second[pos2];

            if (value1 < value2)
            {
                result[idx] = value1;
                idx++;
                pos1++;
            }
            else
            {
                result[idx] = value2;
                idx++;
                pos2++;
            }
        }

        // collect the remaining if any
        while (pos1 < length1)
        {
            result[idx] = first[pos1];
            idx++;
            pos1++;
        }

        while (pos2 < length2)
        {
            result[idx] = second[pos2];
            idx++;
            pos2++;
        }

        return result;
    }
}
