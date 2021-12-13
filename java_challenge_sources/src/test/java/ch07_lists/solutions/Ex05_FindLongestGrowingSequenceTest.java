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
public class Ex05_FindLongestGrowingSequenceTest
{
    @ParameterizedTest(name = "findLongestGrowingSequence({0}) = {1}")
    @MethodSource("listInputsAndExpected")
    public void findLongestGrowingSequence(final List<Integer> inputs, final List<Integer> expected)
    {
        final List<Integer> result = Ex05_FindLongestGrowingSequence.findLongestGrowingSequence(inputs);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "findLongestGrowingSequenceOpt({0}) = {1}")
    @MethodSource("listInputsAndExpected")
    public void findLongestGrowingSequenceOpt(final List<Integer> inputs, final List<Integer> expected)
    {
        final List<Integer> result = Ex05_FindLongestGrowingSequence.findLongestGrowingSequenceOpt(inputs);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "findLongestGrowingSequenceIndexBased({0}) = {1}")
    @MethodSource("listInputsAndExpected")
    public void findLongestGrowingSequenceIndexBased(final List<Integer> inputs, final List<Integer> expected)
    {
        final List<Integer> result = Ex05_FindLongestGrowingSequence.findLongestGrowingSequenceIndexBased(inputs);

        assertEquals(expected, result);
    }

    static Stream<Arguments> listInputsAndExpected()
    {
        return Stream.of(Arguments.of(List.of(7, 2, 7, 1, 2, 5, 7, 1),
                                      List.of(1, 2, 5, 7)),
                         Arguments.of(List.of(7, 2, 7, 1, 2, 3, 8, 1, 2, 3, 4, 5),
                                      List.of(1, 2, 3, 4, 5)),
                         Arguments.of(List.of(1, 1, 2, 2, 2, 3, 3, 3, 3),
                                      List.of(1, 1, 2, 2, 2, 3, 3, 3, 3)),
                         Arguments.of(List.of(), List.of()));
    }
}






