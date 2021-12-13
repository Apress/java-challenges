package ch03_recursion.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex10_NumberPalindrome
{
	private Ex10_NumberPalindrome()
	{
	}

	public static boolean isNumberPalindrome(final int number)
	{
		if (number < 10)
			return true;

		final int factor = calcPowOfTen(number);
		final int divisor = (int) Math.pow(10, factor);

		if (number < divisor * 10)
		{
			final int leftNumber = number / divisor;
			final int rightNumber = number % 10;

			final int remainingNumber = number / 10 % (divisor / 10);
			return leftNumber == rightNumber && isNumberPalindrome(remainingNumber);
		}

		return false;
	}

	private static int calcPowOfTen(final int number)
	{
		return countDigits(number) - 1;
	}

	private static int countDigits(int number)
	{
		int count = 0;
		while (number > 0)
		{
			number = number / 10;
			count++;
		}

		return count;
	}

	// idea: Separate the last digit, then divide by 10 and call the
	// method with the new values. Calculate the new value from the current value
	// and the
	// new value by multiplying the current value by 10 and appending the last
	// digit.
	// If it is a palindrome, then the original value is equal to
	// the calculated value. The recursive termination occurs when no digit exists
	// anymore.
	public static boolean isNumberPalindromeRec(final int number)
	{
		return isNumberPalindromeRec(number, 0, number);
	}

	static boolean isNumberPalindromeRec(final int origNumber, final int currentValue, final int remainingValue)
	{
		// recursive termination
		if (origNumber == currentValue)
			return true;

		// recursive termination
		if (remainingValue < 1)
			return false;

		final int lastDigit = remainingValue % 10;
		final int newRemaining = remainingValue / 10;
		final int newCurrent = currentValue * 10 + lastDigit;

		System.out.println(String.format("lastDigit: %,4d, " +
				"newCurrent: %,4d, newRemaining: %,4d",
				lastDigit, newCurrent, newRemaining));

		// recursive descent
		return isNumberPalindromeRec(origNumber, newCurrent, newRemaining);
	}
}