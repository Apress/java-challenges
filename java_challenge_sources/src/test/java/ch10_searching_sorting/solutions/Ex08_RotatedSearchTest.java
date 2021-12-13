package ch10_searching_sorting.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
public class Ex08_RotatedSearchTest
{
    @ParameterizedTest(name = "findFlankPos({0}) => {2}")
    @MethodSource("createInputAndExpected")
    void findFlankPos(final int[] values, final int expected)
    {
        final int flankpos = Ex08_RotatedSearch.findFlankPos(values);

        assertEquals(expected, flankpos);
    }

    private static Stream<Arguments> createInputAndExpected()
    {
        return Stream.of(Arguments.of(new int[] { 25, 33, 47, 1, 2, 3, 5, 11 }, 3),
                         Arguments.of(new int[] { 6, 7, 1, 2, 3, 4, 5 }, 2),
                         Arguments.of(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 0));
    }

    @ParameterizedTest(name = "binarySearchRotated({0}) => {2}")
    @MethodSource("createInputsAndExpected")
    void binarySearchRotated(final int[] values, final int searchFor, final int expected)
    {
        final int flankpos = Ex08_RotatedSearch.binarySearchRotated(values, searchFor);

        assertEquals(expected, flankpos);
    }

    private static Stream<Arguments> createInputsAndExpected()
    {
        return Stream.of(Arguments.of(new int[] { 25, 33, 47, 1, 2, 3, 5, 11 }, 47, 2),
                         Arguments.of(new int[] { 25, 33, 47, 1, 2, 3, 5, 11 }, 3, 5),
                         Arguments.of(new int[] { 25, 33, 47, 1, 2, 3, 5, 11 }, 13, -1),
                         Arguments.of(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5, 4),
                         Arguments.of(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 13, -1));
    }
}
