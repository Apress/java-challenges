package ch08_recursion_advanced.solutions;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex08_AllPalindromeParts
{
    private Ex08_AllPalindromeParts()
    {
    }

    static Set<String> allPalindromeParts(final String input)
    {
        final Set<String> allPalindromsParts = new TreeSet<>();
        allPalindromePartsRec(input, 0, input.length() - 1, allPalindromsParts);

        return allPalindromsParts;
    }

    static void allPalindromePartsRec(final String input, final int left, final int right, final Set<String> results)
    {
        // recursive termination
        if (left >= right)
            return;

        // 1) Check if the whole string is a palindrome
        final boolean completeIsPalindrome = isPalindromeRec(input, left, right);
        if (completeIsPalindrome)
        {
            final String newCandidate = input.substring(left, right + 1);
            results.add(newCandidate);
        }

        // 2) Try all from left
        for (int i = left + 1; i < right; i++)
        {
            final boolean leftPartIsPalindrome = isPalindromeRec(input, i, right);
            if (leftPartIsPalindrome)
            {
                final String newCandidate = input.substring(i, right + 1);
                results.add(newCandidate);
            }
        }
        // 3) Try all from right
        for (int i = right - 1; i > left; i--)
        {
            final boolean rightPartIsPalindrome = isPalindromeRec(input, left, i);
            if (rightPartIsPalindrome)
            {
                final String newCandidate = input.substring(left, i + 1);
                results.add(newCandidate);
            }
        }

        // recursive descent
        allPalindromePartsRec(input, left + 1, right - 1, results);
    }

    static Set<String> allPalindromePartsOpt(final String input)
    {
        final Set<String> allPalindromsParts = new TreeSet<>();
        allPalindromePartsOpt(input, 0, input.length() - 1, allPalindromsParts);

        return allPalindromsParts;
    }

    static void allPalindromePartsOpt(final String input, final int left, final int right, final Set<String> results)
    {
        // recursive termination
        if (left >= right)
            return;

        // 1) Check if the whole string is a palindrome
        if (isPalindromeRec(input, left, right))
        {
            results.add(input.substring(left, right + 1));
        }

        // recursive descent
        // 2) try from left
        allPalindromePartsOpt(input, left + 1, right, results);

        // 3) try from right
        allPalindromePartsOpt(input, left, right - 1, results);
    }

    public static Optional<String> longestPalindromePart(final String input)
    {
        final Set<String> allPalindromeParts = allPalindromeParts(input);
        final Comparator<String> byLength = Comparator.comparing(String::length);

        return allPalindromeParts.stream().max(byLength);
    }


    static boolean isPalindromeRec(final String input)
    {
        return isPalindromeRec(input, 0, input.length() - 1);
    }

    static boolean isPalindromeRec(final String input,
                                   final int left, final int right)
    {
        // recursive termination
        if (left >= right)
            return true;

        if (input.charAt(left) == input.charAt(right))
        {
            // recursive descent
            return isPalindromeRec(input, left + 1, right - 1);
        }

        return false;
    }

    //////////////////////////////

    static Set<String> allPalindromePartsV3(final String line)
    {
        final Set<String> result = new TreeSet<>();
        allPalindromePartsRecV3(line, result);
        return result;
    }

    static void allPalindromePartsRecV3(final String input, final Set<String> result)
    {
        if (input.length() < 2)
            return;

        if (isPalindromeRec(input))
            result.add(input);

        allPalindromePartsRecV3(input.substring(1), result);
        allPalindromePartsRecV3(input.substring(0, input.length() - 1), result);
    }
}
