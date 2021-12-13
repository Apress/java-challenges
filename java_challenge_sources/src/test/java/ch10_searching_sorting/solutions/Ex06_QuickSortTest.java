package ch10_searching_sorting.solutions;

import static org.junit.Assert.assertArrayEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
class Ex06_QuickSortTest
{
    @Test
    public void testQuickSortSimple()
    {
        int[] values = { 7, 2, 5, 1, 6, 8, 9, 4, 3 };
        int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        Ex06_Quicksort.quickSort(values);

        assertArrayEquals(expected, values);
    }

    @ParameterizedTest(name = "{0} should be sorted to {1}")
    @MethodSource("createInputAndExpected")
    void testQuickSort(int[] values, int[] expected)
    {
        Ex06_Quicksort.quickSort(values);

        assertArrayEquals(expected, values);
    }

    private static Stream<Arguments> createInputAndExpected()
    {
        return Stream.of(Arguments.of(new int[] { 5, 2, 7, 1, 4, 3, 6, 8 }, new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }),
                         Arguments.of(new int[] { 5, 2, 7, 9, 6, 3, 1, 4, 8 }, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }),
                         Arguments.of(new int[] { 5, 2, 7, 9, 6, 3, 1, 4, 2, 3, 8 },
                                      new int[] { 1, 2, 2, 3, 3, 4, 5, 6, 7, 8, 9 }));
    }

}
