package ch04_strings.solutions;

import java.util.Map;
import java.util.TreeMap;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex10_AnagramChecker
{
    private Ex10_AnagramChecker()
    {
    }

    public static boolean isAnagram(final String str1, final String str2)
    {
        final Map<Character, Integer> charCounts1 = calcCharFrequencies(str1);
        final Map<Character, Integer> charCounts2 = calcCharFrequencies(str2);

        return charCounts1.equals(charCounts2);
    }

    private static Map<Character, Integer> calcCharFrequencies(final String input)
    {
        final Map<Character, Integer> charCounts = new TreeMap<>();

        for (char currentChar : input.toUpperCase().toCharArray())
        {
            charCounts.putIfAbsent(currentChar, 0);
            charCounts.computeIfPresent(currentChar, (key, value) -> value + 1);
        }
        return charCounts;
    }
}
