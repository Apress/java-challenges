package ch07_lists.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
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
public class Ex03_RemoveDuplicatesTest
{
    @ParameterizedTest(name = "removeDuplicates({0}) = {1}")
    @MethodSource("listInputsAndExpected")
    public void removeDuplicates(final List<Integer> inputs, final List<Integer> expected)
    {
        final List<Integer> result = Ex03_RemoveDuplicates.removeDuplicates(inputs);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "removeDuplicatesV2({0}) = {1}")
    @MethodSource("listInputsAndExpected")
    public void removeDuplicatesV2(final List<Integer> inputs, final List<Integer> expected)
    {
        final List<Integer> result = Ex03_RemoveDuplicates.removeDuplicatesV2(inputs);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "removeDuplicatesV3({0}) = {1}")
    @MethodSource("listInputsAndExpected")
    public void removeDuplicatesV3(final List<Integer> inputs, final List<Integer> expected)
    {
        final List<Integer> result = Ex03_RemoveDuplicates.removeDuplicatesV3(inputs);

        assertEquals(expected, result);
    }

    static Stream<Arguments> listInputsAndExpected()
    {
        return Stream.of(Arguments.of(List.of(1, 1, 2, 3, 4, 1, 2, 3),
                                      List.of(1, 2, 3, 4)),
                         Arguments.of(List.of(7, 5, 3, 5, 1),
                                      List.of(7, 5, 3, 1)),
                         Arguments.of(List.of(1, 1, 1, 1),
                                      List.of(1)));
    }
}
