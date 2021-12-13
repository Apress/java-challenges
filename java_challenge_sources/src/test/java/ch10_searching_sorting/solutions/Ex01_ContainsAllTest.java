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
public class Ex01_ContainsAllTest
{
    @ParameterizedTest(name = "containsAll({0}, {1}) => {2}")
    @MethodSource("createInputsAndExpected")
    void containsAll(int[] values, int[] searchvalues, boolean expected)
    {
        boolean result = Ex01_ContainsAll.containsAll(values, searchvalues);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> createInputsAndExpected()
    {
        final int[] values = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        final int[] searchValues1 = { 7, 2 };
        final int[] searchValues2 = { 5, 11 };

        return Stream.of(Arguments.of(values, searchValues1, true),
                         Arguments.of(values, searchValues2, false));
    }
}
