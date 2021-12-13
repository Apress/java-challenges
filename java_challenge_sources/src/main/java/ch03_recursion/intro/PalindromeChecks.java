package ch03_recursion.intro;

import java.util.Arrays;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class PalindromeChecks
{
	public static void main(final String[] args)
	{
		final int[] inputsOK = { 1, 2, 3, 2, 1 };
		final boolean isPalindrome1 = isPalindromeSimplRec(inputsOK);
		final boolean isPalindrome1a = isPalindromeRec(inputsOK);
		final boolean isPalindrome1b = isPalindromeIter(inputsOK);
		System.out.println(isPalindrome1 + "/ " + isPalindrome1a + "/ " + isPalindrome1b);

		final int[] inputsWrong = { 1, 2, 3, 4 };
		final boolean isPalindrome2 = isPalindromeSimplRec(inputsWrong);
		final boolean isPalindrome2a = isPalindromeRec(inputsWrong);
		final boolean isPalindrome2b = isPalindromeIter(inputsWrong);
		System.out.println(isPalindrome2  + "/ " + isPalindrome2a  + "/ " + isPalindrome2b);
	}

	// Algorithm: If the array has length 0 or 1, then it is a palidrome,
	// if the length is 2 or greater, then the left and right outer elements are
	// checked and
	// then continue on the remaining part of the array.
	private static boolean isPalindromeSimplRec(final int[] values)
	{
		if (values.length <= 1)
			return true;

		// check if left == right
		final int left = 0;
		final int right = values.length-1;
		if (values[left] == values[right])
		{
			// recursive descent, Attention: copyOfRange, exclusive end
			final int[] reminder = Arrays.copyOfRange(values, left + 1, right);
			return isPalindromeRec(reminder);
		}

		return false;
	}

	private static boolean isPalindromeRec(final int[] values)
	{
		return isPalindromeRec(values, 0, values.length-1);
	}

	private static boolean isPalindromeRec(final int[] values, final int left, final int right)
	{
		if (left >= right)
			return true;

		if (values[left] == values[right])
		{
			// recursive descent
			return isPalindromeRec(values, left + 1, right - 1);
		}

		return false;
	}

	private static boolean isPalindromeIter(final int[] values)
	{
		int left = 0;
		int right = values.length - 1;
		boolean sameValue = true;

		while (left < right && sameValue)
		{
			sameValue = values[left] == values[right];

			left++;
			right--;
		}

		return sameValue;
	}

	static boolean isPalindromeIterativeCompact(final int[] values)
	{
		int left = 0;
		int right = values.length - 1;

		while (left < right && values[left] == values[right])
		{
			left++;
			right--;
		}
		// left >= right || values[left] != values[right]
		return left >= right;
	}
}
