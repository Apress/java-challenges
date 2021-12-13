package ch10_searching_sorting.solutions;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex05_SelectionSortTest
{
    @Test
    public void selectionSortMaxInplace()
    {
        int[] values = { 7, 2, 5, 1, 6, 8, 9, 4, 3 };
        int[] sorted = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        Ex05_SelectionSort.selectionSortMaxInplace(values);

        assertArrayEquals(sorted, values);
    }

    @Test
    public void selectionSortMaxCopy()
    {
        int[] values = { 7, 2, 5, 1, 6, 8, 9, 4, 3 };
        int[] origValues = { 7, 2, 5, 1, 6, 8, 9, 4, 3 };
        int[] sorted = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        int[] result = Ex05_SelectionSort.selectionSortMaxCopy(values);

        assertAll(() -> assertArrayEquals(sorted, result),
                  // ensure values unchanged
                  () -> assertArrayEquals(values, origValues));

    }
}
