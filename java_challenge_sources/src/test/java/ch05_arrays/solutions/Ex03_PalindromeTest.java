package ch05_arrays.solutions;

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
public class Ex03_PalindromeTest
{
    @ParameterizedTest(name = "isPalindromeRec({0}) => {1}")
    @MethodSource("createInputArraysAndExpected")
    void isPalindromeRec(String[] values, boolean expected)
    {
        boolean result = Ex03_Palindrome.isPalindromeRec(values);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "isPalindromeIterative({0}) => {1}")
    @MethodSource("createInputArraysAndExpected")
    void isPalindromeIterative(String[] values, boolean expected)
    {
        boolean result = Ex03_Palindrome.isPalindromeIterative(values);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "isPalindromeShort({0}) => {1}")
    @MethodSource("createInputArraysAndExpected")
    void isPalindromeShort(String[] values, boolean expected)
    {
        boolean result = Ex03_Palindrome.isPalindromeShort(values);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> createInputArraysAndExpected()
    {
        String[] inputsOk1 = { "A", "Test", " -- ", "Test", "A" };
        String[] inputsOk2 = { "Max", "Mike", "Mike", "Max" };
        String[] inputsWrong = { "Tim", "Tom", "Mike", "Max" };

        return Stream.of(Arguments.of(inputsOk1, true), Arguments.of(inputsOk2, true),
                         Arguments.of(inputsWrong, false));
    }
}