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
public class Ex05_CheckNoDuplicateCharsTest
{
    @ParameterizedTest(name = "checkNoDuplicateChars({0}) => {1}")
    @CsvSource({ "Otto, false", "Adrian, false", "Micha, true", "ABCDEFG, true" })
    void checkNoDuplicateChars(final String input, final boolean expected)
    {
        var result = Ex05_CheckNoDuplicateChars.checkNoDuplicateChars(input);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "checkNoDuplicateChars({0}) => {1}")
    @CsvSource({ "Otto, false", "Adrian, false", "Micha, true", "ABCDEFG, true" })
    void checkNoDuplicateCharsWithStreams(final String input, final boolean expected)
    {
        var result = Ex05_CheckNoDuplicateChars.checkNoDuplicateCharsWithStream(input);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "checkNoDuplicateChars({0}) => {1}")
    @CsvSource({ "Otto, false", "Adrian, false", "Micha, true", "ABCDEFG, true" })
    void checkNoDuplicateCharsWithStreamOpt(final String input, final boolean expected)
    {
        var result = Ex05_CheckNoDuplicateChars.checkNoDuplicateCharsWithStreamOpt(input);

        assertEquals(expected, result);
    }
}