package ch10_searching_sorting.intro;

import java.util.Arrays;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class MyMergeSort
{
    public static void main(final String[] args)
    {
        final int[] unsorted = { 7, 2, 6, 3, 4, 5, 8, 1, 9 };

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
        if (toSort.length == 0 || toSort.length == 1)
        {
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

    private static int[] merge(int[] first, int[] second)
    {
        int length1 = first.length;
        int length2 = second.length;

        int[] result = new int[length1 + length2];

        //
        int pos1 = 0;
        int pos2 = 0;
        int idx = 0;

        // continue as long as the two position pointers are less than the length
        while (pos1 < length1 && pos2 < length2)
        {
            int value1 = first[pos1];
            int value2 = second[pos2];

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
