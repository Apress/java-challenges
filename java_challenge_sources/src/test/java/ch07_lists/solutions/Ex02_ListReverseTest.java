package ch07_lists.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
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
public class Ex02_ListReverseTest
{
    @ParameterizedTest(name = "listReverse({0}) = {1}")
    @MethodSource("listInputsAndExpected")
    <T> void listReverse(final List<T> inputs, final List<T> expected)
    {
        final List<T> result = Ex02_ListReverse.listReverse(inputs);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "listReverseInplace({0}) = {1}")
    @MethodSource("listInputsAndExpected")
    <T> void listReverseInplace(final List<T> inputs, final List<T> expected)
    {
        // Allow modification of the list by wrapping
        final List<T> modifiableInputs = new ArrayList<>(inputs);
        Ex02_ListReverse.listReverseInplace(modifiableInputs);

        assertEquals(expected, modifiableInputs);
    }

    @ParameterizedTest(name = "listReverseWithStack({0}) = {1}")
    @MethodSource("listInputsAndExpected")
    <T> void listReverseWithStack(final List<T> inputs, final List<T> expected)
    {
        final List<T> result = Ex02_ListReverse.listReverseWithStack(inputs);

        assertEquals(expected, result);
    }

    static Stream<Arguments> listInputsAndExpected()
    {
        return Stream.of(Arguments.of(List.of(1, 2, 3, 4), List.of(4, 3, 2, 1)),
                         Arguments.of(List.of("A", "BB", "CCC", "DDDD"), List.of("DDDD", "CCC", "BB", "A")));
    }
}
