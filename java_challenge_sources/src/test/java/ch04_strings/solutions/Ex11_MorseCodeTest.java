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
public class Ex11_MorseCodeTest
{
    @ParameterizedTest(name="toMorseCode({0}) => ''{1}''")
    @CsvSource({ "SOS, . . .   - - -   . . .", "TWEET, -   . - -   .   .   -",
        "OST, - - -   . . .   -", "WEST, . - -   .   . . .   -" })
    public void testToMorseCode(final String input, final String expected)
    {
        var result = Ex11_MorseCode.toMorseCode(input);

        assertEquals(expected, result);
    }
}
