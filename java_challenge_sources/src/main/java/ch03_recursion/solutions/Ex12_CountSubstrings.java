package ch03_recursion.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex12_CountSubstrings
{
    private Ex12_CountSubstrings()
    {
    }

    static int countSubstring(final String input, final String valueToFind)
    {
        if (input.length() < valueToFind.length())
            return 0;

        final int count;
        final String remaining;

        if (input.startsWith(valueToFind))
        {
            remaining = input.substring(valueToFind.length());
            count = 1;
        }
        else
        {
            // remove first char and continue searching
            remaining = input.substring(1);
            count = 0;
        }

        return countSubstring(remaining, valueToFind) + count;
    }

    static int countSubstringOpt(final String input, final String valueToFind)
    {
        return countSubstringOpt(input, valueToFind, 0);
    }

    static int countSubstringOpt(final String input, final String valueToFind, int left)
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

        return countSubstringOpt(input, valueToFind, left) + count;
    }

    static int countSubstringV2(final String input, final String valueToFind)
    {
        if (input.length() < valueToFind.length())
            return 0;

        int count = 0;
        if (input.startsWith(valueToFind))
            count = 1;

        // remove first char and continue searching
        final String remaining = input.substring(1);

        return countSubstringV2(remaining, valueToFind) + count;
    }

    static int countSubstringsShort(final String input, final String valueToFind)
    {
        return input.length() < valueToFind.length()
                        ? 0
                        : (input.startsWith(valueToFind) ? 1 : 0)
                        + countSubstringsShort(input.substring(1), valueToFind);
    }

}
