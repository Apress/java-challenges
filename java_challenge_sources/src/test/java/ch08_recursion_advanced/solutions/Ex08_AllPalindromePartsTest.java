package ch08_recursion_advanced.solutions;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.List;
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
public class Ex08_AllPalindromePartsTest
{
    @ParameterizedTest(name = "allPalindromeParts({0}) = {1}")
    @MethodSource("inputAndPalindromeParts")
    void allPalindromePartsRec(final String input, final List<String> expected)
    {
        final Set<String> result = Ex08_AllPalindromeParts.allPalindromeParts(input);

        assertIterableEquals(expected, result);
    }

    @ParameterizedTest(name = "allPalindromePartsOpt({0}) = {1}")
    @MethodSource("inputAndPalindromeParts")
    void allPalindromePartsOpt(final String input, final List<String> expected)
    {
        final Set<String> result = Ex08_AllPalindromeParts.allPalindromePartsOpt(input);

        assertIterableEquals(expected, result);
    }

    @ParameterizedTest(name = "allPalindromePartsV3({0}) = {1}")
    @MethodSource("inputAndPalindromeParts")
    void allPalindromePartsV3(final String input, final List<String> expected)
    {
        final Set<String> result = Ex08_AllPalindromeParts.allPalindromePartsV3(input);

        assertIterableEquals(expected, result);
    }

    private static Stream<Arguments> inputAndPalindromeParts()
    {
        return Stream.of(Arguments.of("BCDEDCB",
                                      List.of("BCDEDCB", "CDEDC", "DED")),
                         Arguments.of("ABALOTTOLL",
                                      List.of("ABA", "LL", "LOTTOL", "OTTO", "TT")),
                         Arguments.of("racecar",
                                      List.of("aceca", "cec", "racecar")));
    }
}
