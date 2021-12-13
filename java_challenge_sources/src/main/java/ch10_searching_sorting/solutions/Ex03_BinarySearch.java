package ch10_searching_sorting.solutions;

import java.util.Arrays;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex03_BinarySearch
{
    private Ex03_BinarySearch()
    {
    }

    public static boolean binarySearch(final int[] sortedValues, final int searchValue)
    {
        final int midPos = sortedValues.length / 2;

        // found
        if (searchValue == sortedValues[midPos])
            return true;

        if (sortedValues.length > 1)
        {
            if (searchValue < sortedValues[midPos])
            {
                // search in lower section
                final int[] lowerHalf = Arrays.copyOfRange(sortedValues, 0, midPos);
                return binarySearch(lowerHalf, searchValue);

            }
            if (searchValue > sortedValues[midPos])
            {
                // search in upper section
                final int[] upperHalf = Arrays.copyOfRange(sortedValues, midPos + 1, sortedValues.length);
                return binarySearch(upperHalf, searchValue);
            }
        }

        return false;
    }

    public static boolean binarySearchOptimized(final int[] values, final int searchValue)
    {
        return binarySearchOptimized(values, searchValue, 0, values.length - 1);
    }

    public static boolean binarySearchOptimized(final int[] values, final int searchValue, final int left,
                                                final int right)
    {
        if (right >= left)
        {
            final int midIdx = (left + right) / 2;

            if (searchValue == values[midIdx])
                return true;

            // recursive descent: search in the lower / upper part
            if (searchValue < values[midIdx])
                return binarySearchOptimized(values, searchValue, left, midIdx - 1);
            else
                return binarySearchOptimized(values, searchValue, midIdx + 1, right);
        }
        return false;
    }

    static int binarySearchOptimizedWithPos(final int[] values, final int searchValue)
    {
        return binarySearchOptimizedWithPos(values, searchValue, 0, values.length - 1);
    }

    static int binarySearchOptimizedWithPos(final int[] values,
                                            final int searchValue,
                                            final int left, final int right)
    {
        if (right >= left)
        {
            final int midIdx = (left + right)/2;

            if (searchValue == values[midIdx])
                return midIdx;

            if (searchValue < values[midIdx])
                return binarySearchOptimizedWithPos(values, searchValue, left, midIdx - 1);
            else
                return binarySearchOptimizedWithPos(values, searchValue, midIdx + 1, right);
        }

        return -1;
    }

    static int binarySearchIterative(final int[] values, final int searchValue)
    {
        int left = 0;
        int right = values.length - 1;

        while (right >= left)
        {
            final int midIdx = (left + right) / 2;

            if (searchValue == values[midIdx])
                return midIdx;

            if (searchValue < values[midIdx])
            {
                right = midIdx - 1;
            }
            else
            {
                left = midIdx + 1;
            }
        }

        return -1;
    }
}
