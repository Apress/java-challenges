package ch05_arrays.solutions;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
public class Ex08_AddOneToAnArrayOfNumbersTest
{
    @ParameterizedTest(name = "addOne({0}) => {1}")
    @MethodSource("intArrays")
    void addOne(int[] input, int[] expected)
    {
        int[] result = Ex08_AddOneToAnArrayOfNumbers.addOne(input);

        assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> intArrays()
    {
        int[] values1 = { 1, 3, 2, 4 };
        int[] expected1 = { 1, 3, 2, 5 };

        int[] values2 = { 1, 4, 8, 9 };
        int[] expected2 = { 1, 4, 9, 0 };

        int[] values3 = { 1, 3, 9, 9 };
        int[] expected3 = { 1, 4, 0, 0 };

        int[] values4 = { 9, 9, 9, 9 };
        int[] expected4 = { 1, 0, 0, 0, 0 };

        return Stream.of(Arguments.of(values1, expected1),
                         Arguments.of(values2, expected2),
                         Arguments.of(values3, expected3),
                         Arguments.of(values4, expected4));
    }
}