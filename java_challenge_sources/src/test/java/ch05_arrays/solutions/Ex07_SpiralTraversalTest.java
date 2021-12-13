package ch05_arrays.solutions;

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
public class Ex07_SpiralTraversalTest
{
    @ParameterizedTest(name="spiralTraversal({0}) => {1}")
    @MethodSource("createArrayAndExpected")
    public void spiralTraversal(final Object[][] values, final List<Object> expected)
    {
        final var result = Ex07_SpiralTraversal.spiralTraversal(values);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "spiralTraversalOptimized({0}) => {1}")
    @MethodSource("createArrayAndExpected")
    public void spiralTraversalOptimized(final Object[][] values, final List<Object> expected)
    {
        final var result = Ex07_SpiralTraversal.spiralTraversalOptimized(values);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> createArrayAndExpected()
    {
        final String[][] letters = { { "A", "B", "C", "D" },
                                     { "J", "K", "L", "E" },
                                     { "I", "H", "G", "F" } };

        final Integer[][] numbers = { { 1, 2, 3, 4 },
                                      { 12, 13, 14, 5 },
                                      { 11, 16, 15, 6 },
                                      { 10, 9, 8, 7 } };

        return Stream.of(Arguments.of(letters,
                                      List.of("A","B", "C", "D", "E", "F",
                                              "G", "H", "I", "J", "K", "L")),
                         Arguments.of(numbers,
                                      List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                                              11, 12, 13, 14, 15, 16)));
    }
}
