package ch05_arrays.solutions;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Beispielprogramm für das Buch "Java Challenge"
 *
 * @author Michael Inden
 *
 * Copyright 2020 by Michael Inden
 */
public class Ex12_ArraysMinMaxTest
{
    @Test
    void findMinAndMax()
    {
        final int[] values = { 2, 3, 4, 5, 6, 7, 8, 9, 1, 10 };

        assertAll(() -> assertEquals(1, Ex12_ArraysMinMax.findMin(values)),
                  () -> assertEquals(10, Ex12_ArraysMinMax.findMax(values)));
    }

    @ParameterizedTest(name = "findMinPos([5, 3, 4, 2, 6, 7, 8, 9, 1, 10], " + "{0}, {1}) => {1}")
    @CsvSource({ "0, 10, 8, 1", "2, 7, 3, 2", "0, 7, 3, 2" })
    void findMinxPos(final int lower, final int upper, final int expectedPos, final int expectedValue)
    {
        final int[] values = { 5, 3, 4, 2, 6, 7, 8, 9, 1, 10 };

        final int resultPos = Ex12_ArraysMinMax.findMinPos(values, lower, upper);

        assertEquals(expectedPos, resultPos);
        assertEquals(expectedValue, values[resultPos]);
    }

    @ParameterizedTest(name = "findMaxPos([1, 22, 3, 4, 5, 10, 7, 8, 9, 49], " + "{0}, {1}) => {1}")
    @CsvSource({ "0, 10, 9, 49", "2, 7, 5, 10", "0, 7, 1, 22" })
    void findMaxPos(final int lower, final int upper, final int expectedPos, final int expectedValue)
    {
        final int[] values = { 1, 22, 3, 4, 5, 10, 7, 8, 9, 49 };

        final int resultPos = Ex12_ArraysMinMax.findMaxPos(values, lower, upper);

        assertEquals(expectedPos, resultPos);
        assertEquals(expectedValue, values[resultPos]);
    }
}
