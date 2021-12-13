package ch07_lists.solutions;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
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
public class Ex08_MagicTriangleTest
{
    @Test
    public void testIsMagic6()
    {
        final List<Integer> magic = List.of(1, 5, 3, 4, 2, 6);
        final List<Integer> wrong = List.of(1, 2, 3, 4, 5, 6);

        assertAll(() -> assertTrue(Ex08_MagicTriangle.isMagic6(magic)),
                  () -> assertFalse(Ex08_MagicTriangle.isMagic6(wrong)));
    }

    @Test
    public void isMagic6V2()
    {
        final List<Integer> magic = List.of(1, 5, 3, 4, 2, 6);
        final List<Integer> wrong = List.of(1, 2, 3, 4, 5, 6);

        assertAll(() -> assertTrue(Ex08_MagicTriangle.isMagic6_V2(magic)),
                  () -> assertFalse(Ex08_MagicTriangle.isMagic6_V2(wrong)));
    }

    @ParameterizedTest(name = "isMagic({0})? {1}")
    @MethodSource("listInputsAndExpected")
    public void isMagic(final List<Integer> inputs, final boolean expected)
    {
        final boolean result = Ex08_MagicTriangle.isMagic(inputs);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "isMagicV2({0})? {1}")
    @MethodSource("listInputsAndExpected")
    public void isMagicV2(final List<Integer> inputs, final boolean expected)
    {
        final boolean result = Ex08_MagicTriangle.isMagicV2(inputs);

        assertEquals(expected, result);
    }

    static Stream<Arguments> listInputsAndExpected()
    {
        return Stream.of(Arguments.of(List.of(1, 5, 3, 4, 2, 6), true),
                         Arguments.of(List.of(1, 2, 3, 4, 5, 6), false),
                         Arguments.of(List.of(2, 5, 9, 1, 6, 7, 3, 4, 8), true),
                         Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), false));
    }
}
