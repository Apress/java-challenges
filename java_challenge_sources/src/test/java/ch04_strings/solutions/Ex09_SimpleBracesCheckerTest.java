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
public class Ex09_SimpleBracesCheckerTest
{
    @ParameterizedTest(name = "checkBraces(''{0}'') -- hint: {2}")
    @CsvSource({ "(()), true, ok",
        "()(), true, ok",
        "(()))((()), false, not properly nested",
    "((), false, no suitable bracing" })
    void checkBraces(String input, boolean expected, String hint)
    {
        boolean result = Ex09_SimpleBracesChecker.checkBraces(input);

        assertEquals(expected, result);
    }
}
