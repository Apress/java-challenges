package ch04_strings.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex03_ReverseString
{
    private Ex03_ReverseString()
    {
    }

    static String reverse(final String original)
    {
        String reversed = "";

        for (int i = original.length() - 1; i >= 0; i--)
        {
            final char currentChar = original.charAt(i);
            reversed += currentChar;
        }

        return reversed;
    }

    static String reverseWithSB(final String original)
    {
        final StringBuilder reversed = new StringBuilder(original.length());

        final char[] originalChars = original.toCharArray();

        for (int i = originalChars.length - 1; i >= 0; i--)
        {
            final char currentChar = originalChars[i];
            reversed.append(currentChar);
        }

        return reversed.toString();
    }

    static String reverseWithSB_Optimized(final String original)
    {
        final StringBuilder sb = new StringBuilder(original);

        return sb.reverse().toString();
    }

    public static String reverseInplace(final String original)
    {
        final char[] originalChars = original.toCharArray();

        int left = 0;
        int right = originalChars.length - 1;

        while (left < right)
        {
            final char leftChar = originalChars[left];
            final char rightChar = originalChars[right];

            // swap
            originalChars[left] = rightChar;
            originalChars[right] = leftChar;

            left++;
            right--;
        }

        return String.valueOf(originalChars);
    }
}
