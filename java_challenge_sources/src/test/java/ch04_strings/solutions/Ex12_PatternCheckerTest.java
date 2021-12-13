package ch04_strings.solutions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex12_PatternCheckerTest
{
    @Test
    public void test1()
    {
        var input = "red black black red";
        var pattern = "xyyx";

        assertTrue(Ex12_PatternChecker.matchesPattern(pattern, input));
    }

    @Test
    public void test1b()
    {
        var input = "red black black red";
        var pattern = "xyxy";

        assertFalse(Ex12_PatternChecker.matchesPattern(pattern, input));
    }

    @Test
    public void test1c()
    {
        var input = "red black black red";
        var pattern = "xyzx";

        // Special case => No duplicates in values
        assertFalse(Ex12_PatternChecker.inputMatchesPatternNoDuplicateValuesForKeys(pattern, input));
    }

    @Test
    public void test1d()
    {
        var input = "red black lila red lila";
        var pattern = "xyzxz";

        assertTrue(Ex12_PatternChecker.matchesPattern(pattern, input));
    }


    @Test
    public void test2()
    {
        var input = "red black red red";
        var pattern = "xyxx";

        assertTrue(Ex12_PatternChecker.matchesPattern(pattern, input));
    }

    @Test
    public void test3()
    {
        var input = "red black red green";
        var pattern = "xyxx";

        assertFalse(Ex12_PatternChecker.matchesPattern(pattern, input));
    }


    @Test
    public void test4()
    {
        var input = "red red red red";
        var pattern = "xxxx";

        assertTrue(Ex12_PatternChecker.matchesPattern(pattern, input));
    }


    @ParameterizedTest
    @CsvSource( {"xyyx, red black black red, true",
        "xyxy, red black black red, false",
        "xyzx, red black black red, true",
        "xyzxz, red black lila red lila, true",
        "xyxx, red black red red, true",
        "xyxx, red black red green, false",
    "xxxx, red red red red, true" })
    public void testAllCombinations(String pattern, String input, boolean expected)
    {
        boolean result = Ex12_PatternChecker.matchesPattern(pattern, input);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource( {"xyyx, red black black red, true",
        "xyxy, red black black red, false",
        "xyzx, red black black red, false",  // inputMatchesPatternNoDuplicateValuesForKeys
        "xyzxz, red black lila red lila, true",
        "xyxx, red black red red, true",
        "xyxx, red black red green, false",
    "xxxx, red red red red, true" })
    public void testAllCombinationsNoDuplicates(String pattern, String input, boolean expected)
    {
        boolean result = Ex12_PatternChecker.inputMatchesPatternNoDuplicateValuesForKeys(pattern, input);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "pattern ''{0}'' matches ''{1}'' => {2}")
    @CsvSource( {"xyyx, tim mike mike tim, true",
        "xyyx, time mike tom tim, false",
        "xyxx, tim mike mike tim, false",
    "xxxx, tim tim tim tim, true" })
    void testMatchesPattern(String pattern, String input, boolean expected)
    {
        boolean result = Ex12_PatternChecker.matchesPattern(pattern, input);

        assertEquals(expected, result);
    }

    @Test
    void testSpecialCasees()
    {
        assertAll(
                  () -> assertFalse(Ex12_PatternChecker.matchesPattern("x", "")),
                  () -> assertFalse(Ex12_PatternChecker.matchesPattern("", "x")));
    }
}
