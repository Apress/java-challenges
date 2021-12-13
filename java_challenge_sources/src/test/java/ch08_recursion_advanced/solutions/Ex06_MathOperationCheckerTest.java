package ch08_recursion_advanced.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.Set;
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
public class Ex06_MathOperationCheckerTest
{
    @ParameterizedTest(name = "allCombinations({0}) = {1}")
    @MethodSource("digitsAndCombinations")
    void allCombinations(final List<Integer> numbers, final Map<String, Integer> expected)
    {
        final var result = Ex06_MathOperationChecker.allCombinations(numbers);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> digitsAndCombinations()
    {
        final var results = Map.ofEntries(Map.entry("12-3", 9L), Map.entry("123", 123L), Map.entry("1+2+3", 6L),
                                          Map.entry("1+2-3", 0L), Map.entry("1-2+3", 2L), Map.entry("1-23", -22L),
                                          Map.entry("1-2-3", -4L), Map.entry("1+23", 24L), Map.entry("12+3", 15L));

        return Stream.of(Arguments.of(List.of(1, 2, 3), results));
    }

    @ParameterizedTest(name = "allCombinationsWithValue({0}, {1}) = {2}")
    @MethodSource("digitsAndCombinationsWithResult100")
    void allCombinationsWithValue(final List<Integer> numbers, final int desiredValue, final Set<String> expected)
    {
        final var result = Ex06_MathOperationChecker.allCombinationsWithValue(numbers, desiredValue);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> digitsAndCombinationsWithResult100()
    {
        final var results = Set.of("1+23-4+5+6+78-9", "12+3+4+5-6-7+89", "123-45-67+89", "123+4-5+67-89",
                                   "123-4-5-6-7+8-9", "123+45-67+8-9", "1+2+3-4+5+6+78+9", "12+3-4+5+67+8+9",
                                   "1+23-4+56+7+8+9", "1+2+34-5+67-8+9", "12-3-4+5-6+7+89");

        return Stream.of(Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), 100, results));
    }
}
