package ch04_strings.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex04_Palindrome
{
    private Ex04_Palindrome()
    {
    }

    // pattern/strategy: delegation to helper method
    public static boolean isPalindromeRec(final String input)
    {
        return isPalindromeRec(input.toLowerCase(), 0, input.length() - 1);
    }

    static boolean isPalindromeRec(final String input, final int left, final int right)
    {
        if (left >= right)
            return true;

        if (input.charAt(left) == input.charAt(right))
        {
            return isPalindromeRec(input, left + 1, right - 1);
        }

        return false;
    }

    public static boolean isPalindrome(final String input,
                                       final boolean ignoreSpacesAndPunctuation)
    {
        String adjustedInput = input.toLowerCase();
        if (ignoreSpacesAndPunctuation)
            adjustedInput = input.replaceAll(" |!|\\.", "");

        return isPalindromeRec(adjustedInput);
    }

    static boolean isPalindromeIterative(final String input)
    {
        return isPalindromeIter(input.toLowerCase(), 0, input.length() - 1);
    }

    public static boolean isPalindromeIter(final String input, int left, int right)
    {
        boolean sameChar = true;

        while (left < right && sameChar)
        {
            sameChar = input.charAt(left) == input.charAt(right);

            left++;
            right--;
        }

        return sameChar;
    }
}
