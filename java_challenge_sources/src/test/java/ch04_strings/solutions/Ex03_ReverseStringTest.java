package ch04_strings.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex03_ReverseStringTest
{
    @ParameterizedTest(name = "reverse({0}) => {1}")
    @CsvSource({ "ABCD, DCBA", "OTTO, OTTO", "PETER, RETEP" })
    void testReverse(final String input, final String expectedOutput)
    {
        final String result = Ex03_ReverseString.reverse(input);

        assertEquals(expectedOutput, result);
    }

    @ParameterizedTest(name = "reverseInplace({0}) => {1}")
    @CsvSource({ "ABCD, DCBA", "OTTO, OTTO", "PETER, RETEP" })
    void reverseInplace(final String input, final String expectedOutput)
    {
        final String result = Ex03_ReverseString.reverseInplace(input);

        assertEquals(expectedOutput, result);
    }

    @ParameterizedTest(name = "reverseWithSB({0}) => {1}")
    @CsvSource({ "ABCD, DCBA", "OTTO, OTTO", "PETER, RETEP" })
    void reverseWithSB(final String input, final String expectedOutput)
    {
        final String result = Ex03_ReverseString.reverseWithSB(input);

        assertEquals(expectedOutput, result);
    }

    @ParameterizedTest(name = "reverseWithSB_Optimized({0}) => {1}")
    @CsvSource({ "ABCD, DCBA", "OTTO, OTTO", "PETER, RETEP" })
    void reverseWithSB_Optimized(final String input, final String expectedOutput)
    {
        final String result = Ex03_ReverseString.reverseWithSB_Optimized(input);

        assertEquals(expectedOutput, result);
    }
}
