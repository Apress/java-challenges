package ch05_arrays.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex03_Palindrome
{
    private Ex03_Palindrome()
    {
    }

    static boolean isPalindromeRec(final String[] values)
    {
        return isPalindromeRec(values, 0, values.length - 1);
    }

    private static boolean isPalindromeRec(final String[] values, final int left, final int right)
    {
        if (left >= right)
            return true;

        // check links == rechts
        if (values[left].equals(values[right]))
        {
            // recursive descent
            return isPalindromeRec(values, left + 1, right - 1);
        }

        return false;
    }

    static boolean isPalindromeIterative(final String[] values)
    {
        int left = 0;
        int right = values.length - 1;
        boolean sameValue = true;

        while (left <= right && sameValue)
        {
            sameValue = values[left].equals(values[right]);
            left++;
            right--;
        }

        return sameValue;
    }

    static boolean isPalindromeShort(final String[] values)
    {
        final int length = values.length;
        for (int i = 0; i < length / 2; i++)
        {
            if (!values[i].equals(values[length - 1 - i]))
                return false;
        }
        return true;
    }
}
