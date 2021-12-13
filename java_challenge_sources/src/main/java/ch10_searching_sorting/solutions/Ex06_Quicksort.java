package ch10_searching_sorting.solutions;

import ch05_arrays.util.ArrayUtils;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex06_Quicksort
{
    private Ex06_Quicksort()
    {
    }

    public static void quickSort(final int[] values)
    {
        quicksort(values, 0, values.length - 1);
    }

    public static void quicksort(final int[] values, final int left, final int right)
    {
        // recursive termination
        if (left >= right)
            return;

        final int partitionIndex = partition(values, left, right);

        // recursive descent
        quicksort(values, left, partitionIndex - 1);
        quicksort(values, partitionIndex + 1, right);
    }


    static int partition(final int[] values, final int left, final int right)
    {
        final int pivot = values[left];

        int leftIndex = left + 1;
        int rightIndex = right;

        while (leftIndex < rightIndex)
        {
            // Move the position leftIndex to the right, as long as value is less
            // than or equal to pivot and left boundary is less than right boundary.
            while (values[leftIndex] <= pivot && leftIndex < rightIndex)
            {
                leftIndex++;
            }

            // Move the position rightIndex to the left, as long as value greater
            // than Pivot and right limit greater than or equal to left limit
            while (pivot < values[rightIndex] && rightIndex >= leftIndex)
            {
                rightIndex--;
            }

            if (leftIndex < rightIndex)
                ArrayUtils.swap(values, leftIndex, rightIndex);
        }

        // Special case 2-element array with wrong sorting, but no pass (because leftIndex == rightIndex)
        // as well as normal case at the very end
        if (values[rightIndex] < pivot)
            ArrayUtils.swap(values, left, rightIndex);

        return rightIndex;
    }
}