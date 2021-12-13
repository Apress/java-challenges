package ch10_searching_sorting.solutions;

import ch05_arrays.util.ArrayUtils;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex04_InsertionSort
{
    private Ex04_InsertionSort()
    {
    }

    public static void insertionSort(int[] values)
    {
        for (int i = 1; i < values.length; i++)
        {
            // check if current element is larger than predecessor
            int currentIdx = i;
            while (currentIdx > 0 && values[currentIdx - 1] > values[currentIdx])
            {
                ArrayUtils.swap(values, currentIdx - 1, currentIdx);
                currentIdx--;
            }
        }
    }
}