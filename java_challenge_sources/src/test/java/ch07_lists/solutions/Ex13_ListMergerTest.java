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
public class Ex13_ListMergerTest
{
    @ParameterizedTest(name = "listMerge({0}, {1}) = {2}")
    @MethodSource("listInputsAndExpected")
    public void listMerge(final List<Integer> inputs1, final List<Integer> inputs2, final List<Integer> expected)
    {
        final List<Integer> result = Ex13_ListMerger.merge(inputs1, inputs2);

        assertEquals(expected, result);
    }

    static Stream<Arguments> listInputsAndExpected()
    {
        return Stream.of(Arguments.of(List.of(1, 4, 7, 12, 20), List.of(10, 15, 17, 33),
                                      List.of(1, 4, 7, 10, 12, 15, 17, 20, 33)),
                         Arguments.of(List.of(2, 3, 5, 7), List.of(11, 13, 17),
                                      List.of(2, 3, 5, 7, 11, 13, 17)),
                         Arguments.of(List.of( 1, 2, 3), List.of(),
                                      List.of( 1, 2, 3)));
    }
}
