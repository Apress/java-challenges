package ch10_searching_sorting.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
public class Ex03_BinarySearchTest
{
    @ParameterizedTest(name = "binarySearch in {0} for {1} => {2}")
    @MethodSource("createInputsAndExpected")
    void binarySearch(int[] values, int searchFor, boolean expected)
    {
        boolean result = Ex03_BinarySearch.binarySearch(values, searchFor);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> createInputsAndExpected()
    {
        final int[] values = { 1, 2, 3, 4, 5, 7, 8, 9 };

        return Stream.of(Arguments.of(values, 5, true), Arguments.of(values, 6, false));
    }

    @ParameterizedTest(name = "binarySearchOptimized in {0} for {1} => {2}")
    @MethodSource("createInputsAndExpected")
    void binarySearchOptimized(int[] values, int searchFor, boolean expected)
    {
        boolean result = Ex03_BinarySearch.binarySearchOptimized(values, searchFor);

        assertEquals(expected, result);
    }

    // --------------------------------------------------

    @Test
    void binarySearchIterative_should_return_pos()
    {
        final int[] values = { 1, 2, 3, 4, 5, 7, 8, 9 };

        int result = Ex03_BinarySearch.binarySearchIterative(values, 5);

        assertEquals(4, result);
    }

    @Test
    void binarySearchIterative_no_value()
    {
        final int[] values = { 1, 2, 3, 4, 5, 7, 8, 9 };

        int result = Ex03_BinarySearch.binarySearchIterative(values, 6);

        assertEquals(-1, result);
    }

    @Test
    void binarySearchOptimizedWithPos_should_return_pos()
    {
        final int[] values = { 1, 2, 3, 4, 5, 7, 8, 9 };

        int result = Ex03_BinarySearch.binarySearchOptimizedWithPos(values, 5);

        assertEquals(4, result);
    }

    @Test
    void binarySearchOptimizedWithPos_no_value()
    {
        final int[] values = { 1, 2, 3, 4, 5, 7, 8, 9 };

        int result = Ex03_BinarySearch.binarySearchOptimizedWithPos(values, 6);

        assertEquals(-1, result);
    }
}
