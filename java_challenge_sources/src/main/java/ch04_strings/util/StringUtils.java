package ch04_strings.util;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class StringUtils
{
    public static String reverse(final String original)
    {
        final StringBuilder sb = new StringBuilder(original);

        return sb.reverse().toString();
    }

    public static boolean isPalindromeRec(final String input)
    {
        return isPalindromeRec(input.toLowerCase(), 0, input.length() - 1);
    }

    public static boolean isPalindromeRec(final String input, final int left, final int right)
    {
        if (left >= right)
            return true;

        if (input.charAt(left) == input.charAt(right))
        {
            return isPalindromeRec(input, left + 1, right - 1);
        }

        return false;
    }

    public static boolean checkNoDuplicateChars(final String input)
    {
        return input.toLowerCase().chars().distinct().count() == input.length();
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

    public static int compareVersions(final String v1, final String v2)
    {
        var v1Numbers = v1.split("\\."); // Achtung: Reg-Ex, . macht jedes Zeichen!
        var v2Numbers = v2.split("\\.");

        int pos = 0;
        int compareResult = 0;
        while (pos < v1Numbers.length && pos < v2Numbers.length && compareResult == 0)
        {
            var currentV1 = Integer.valueOf(v1Numbers[pos]);
            var currentV2 = Integer.valueOf(v2Numbers[pos]);

            compareResult = Integer.compare(currentV1, currentV2);
            pos++;
        }

        if (compareResult == 0)
        {
            // same prefix number (eg. 3.1 and 3.1.7)
            return Integer.compare(v1Numbers.length, v2Numbers.length);
        }

        return compareResult;
    }

    static Comparator<String> versioNumberComparator = (v1, v2) -> compareVersions(v1, v2);
}