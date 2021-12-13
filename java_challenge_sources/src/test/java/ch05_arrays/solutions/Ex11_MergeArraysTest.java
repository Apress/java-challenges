package ch05_arrays.solutions;

import static org.junit.Assert.assertArrayEquals;

import java.util.stream.Stream;

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
public class Ex11_MergeArraysTest
{
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @MethodSource("createArraysAndExpected")
    public void merge(int[] values1, int[] values2, int[] expecteds)
    {
        int[] result = Ex11_MergeArrays.merge(values1, values2);

        assertArrayEquals(expecteds, result);
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @MethodSource("createArraysAndExpected")
    public void mergeCompact(int[] values1, int[] values2, int[] expecteds)
    {
        int[] result = Ex11_MergeArrays.mergeCompact(values1, values2);

        assertArrayEquals(expecteds, result);
    }

    private static Stream<Arguments> createArraysAndExpected()
    {
        int[] values1a = { 1, 4, 7, 12, 20 };
        int[] values1b = { 10, 15, 17, 33 };
        int[] result1 = { 1, 4, 7, 10, 12, 15, 17, 20, 33 };

        int[] values2a = { 2, 3, 5, 7 };
        int[] values2b = { 11, 13, 17 };
        int[] result2 = { 2, 3, 5, 7, 11, 13, 17 };

        int[] values3a = { 2, 3, 5, 22 };
        int[] values3b = { 7, 11, 13, 17 };
        int[] result3 = { 2, 3, 5, 7, 11, 13, 17, 22 };

        return Stream.of(Arguments.of(values1a, values1b, result1), Arguments.of(values2a, values2b, result2),
                         Arguments.of(values3a, values3b, result3));
    }
}