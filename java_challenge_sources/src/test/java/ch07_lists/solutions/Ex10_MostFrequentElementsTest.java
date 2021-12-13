package ch07_lists.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
public class Ex10_MostFrequentElementsTest
{
    @ParameterizedTest(name = "valueCount({0}) = {1}")
    @MethodSource("listInputsAndExpected")
    public void valueCount(final List<Integer> inputs, final Map<Integer, Long> expected)
    {
        final Map<Integer, Long> result = Ex10_MostFrequentElements.valueCount(inputs);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "valueCountV2({0}) = {1}")
    @MethodSource("listInputsAndExpected")
    public void valueCountV2(final List<Integer> inputs, final Map<Integer, Long> expected)
    {
        final Map<Integer, Long> result = Ex10_MostFrequentElements.valueCountV2(inputs);

        assertEquals(expected, result);
    }

    static Stream<Arguments> listInputsAndExpected()
    {
        return Stream.of(Arguments.of(List.of(1, 2, 3, 4, 4, 4, 3, 3, 2, 4),
                                      Map.of(1, 1L, 2, 2L, 3, 3L, 4, 4L)),
                         Arguments.of(List.of(1, 1, 1, 2, 2, 2, 3, 3, 3),
                                      Map.of(1, 3L, 2, 3L, 3, 3L)));
    }

    @Test
    public void sortByValue()
    {
        final Map<Integer, Long> counts = Map.of(1, 1L, 2, 2L, 3, 3L, 4, 4L);
        final Map<Integer, Long> expected = new LinkedHashMap<>();
        expected.put(4, 4L);
        expected.put(3, 3L);
        expected.put(2, 2L);
        expected.put(1, 1L);

        final Map<Integer, Long> result = Ex10_MostFrequentElements.sortByValue(counts);

        assertIterableEquals(expected.entrySet(), result.entrySet());
    }

    static Stream<Arguments> listInputsAndExpectedMaps()
    {
        return Stream.of(Arguments.of(List.of(1, 2, 3, 4, 4, 4, 3, 3, 2, 4),
                                      Map.of(1, 1L, 2, 2L, 3, 3L, 4, 4L),
                                      Map.of(4, 4L, 3, 3L, 2, 2L, 1, 1L)),
                         Arguments.of(List.of(1, 1, 1, 2, 2, 2, 3, 3, 3),
                                      Map.of(1, 3L, 2, 3L, 3, 3L), // ofEntires schöner?
                                      Map.of(1, 3L, 2, 3L, 3, 3L)));
    }
}
