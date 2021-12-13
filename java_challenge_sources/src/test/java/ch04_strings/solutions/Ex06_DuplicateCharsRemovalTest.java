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
public class Ex06_DuplicateCharsRemovalTest
{
    @ParameterizedTest(name = "removeDuplicates({0}) => {1}")
    @CsvSource({ "bananas, bans", "lalalamama, lam", "MICHAEL, MICHAEL" })
    void testRemoveDuplicates(final String input, final String expected)
    {
        var result = Ex06_DuplicateCharsRemoval.removeDuplicates(input);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "removeDuplicatesImproved({0}) => {1}")
    @CsvSource({ "bananas, bans", "lalalamama, lam", "MICHAEL, MICHAEL" })
    void removeDuplicatesImproved(final String input, final String expected)
    {
        var result = Ex06_DuplicateCharsRemoval.removeDuplicatesImproved(input);

        assertEquals(expected, result);
    }
}
