package ch03_recursion.util;

import java.util.HashSet;
import java.util.Set;

import ch02_math.util.MathUtils;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class RecursionUtils
{
    static long fibRec(final int n)
    {
        if (n <= 0)
            throw new IllegalArgumentException("n must be positive and >= 1");

        // recursive termination
        if (n == 1 || n == 2)
            return 1;

        // recursive descent
        return fibRec(n - 1) + fibRec(n - 2);
    }

    static long fibIterative(final int n)
    {
        if (n <= 0)
            throw new IllegalArgumentException("n must be >= 1");

        if (n == 1 || n == 2)
            return 1;

        long fibN_2 = 1;
        long fibN_1 = 1;

        for (int count = 2; count < n; count++)
        {
            long fibN = fibN_1 + fibN_2;

            fibN_2 = fibN_1;
            fibN_1 = fibN;
        }

        return fibN_1;
    }

    public static boolean isNumberPalindrome(final int number)
    {
        if (number < 10)
            return true;

        final int factor = MathUtils.calcPowOfTen(number);
        final int divisor = (int)Math.pow(10, factor);

        if (number < divisor * 10)
        {
            final int leftNumber = number / divisor;
            final int rightNumber = number % 10;

            final int remainingNumber = number / 10 % (divisor / 10);
            return leftNumber == rightNumber && isNumberPalindrome(remainingNumber);
        }

        return false;
    }

    public static int calcDigits(final int value)
    {
        if (value < 0)
            throw new IllegalArgumentException("value must be >= 0");

        if (value < 10)
            return 1;

        final int remainder = value / 10;

        return calcDigits(remainder) + 1;
    }

    public static int calcSumOfDigits(final int value)
    {
        if (value < 0)
            throw new IllegalArgumentException("value must be >= 0");

        if (value < 10)
            return value;

        final int remainder = value / 10;
        final int lastDigit = value % 10;

        return calcSumOfDigits(remainder) + lastDigit;
    }

    public static int gcd(final int a, final int b)
    {
        if (b == 0)
            return a;

        final int remainder = a % b;

        return gcd(b, remainder);
    }

    public static int gcdIterative(int a, int b)
    {
        while (b != 0)
        {
            final int remainder = a % b;
            a = b;
            b = remainder;
        }

        // b == 0
        return a;
    }

    public static int lcm(final int a, final int b)
    {
        return a * b / gcd(a, b);
    }

    public static Set<String> calcPermutations(final String input)
    {
        return calcPermutations(input, "");
    }

    private static Set<String> calcPermutations(final String remaining, final String prefix)
    {
        if (remaining.length() == 0)
            return Set.of(prefix);

        final Set<String> candidates = new HashSet<>();

        for (int i = 0; i < remaining.length(); i++)
        {
            // first part
            final String newPrefix = prefix + remaining.charAt(i);

            // rest (without extracted character)
            final String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);

            candidates.addAll(calcPermutations(newRemaining, newPrefix));
        }

        return candidates;
    }

    public static int countSubstring(final String input, final String valueToFind)
    {
        return countSubstring(input, valueToFind, 0);
    }

    private static int countSubstring(final String input, final String valueToFind, int left)
    {
        if (input.length() - left < valueToFind.length())
            return 0;

        int count = 0;
        if (input.startsWith(valueToFind, left))
        {
            left += valueToFind.length();
            count = 1;
        }
        else
        {
            // skip char and search again
            left++;
        }

        return countSubstring(input, valueToFind, left) + count;
    }
}
