package ch10_searching_sorting.solutions;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex04_InsertionSortTest
{
    @Test
    public void testInsertionSort()
    {
        int[] values = { 7, 2, 5, 1, 6, 8, 9, 4, 3 };
        int[] sorted = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        Ex04_InsertionSort.insertionSort(values);

        assertArrayEquals(sorted, values);
    }
}
