package ch03_recursion.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex07_NumberConversions
{
	private Ex07_NumberConversions()
	{
	}

	public static String toBinary(final int n)
	{
		if (n < 0)
			throw new IllegalArgumentException("n must be >= 0");

		if (n <= 1)
			return String.valueOf(n);

		final int lastDigit = n % 2;
		final int remainder = n / 2;

		return toBinary(remainder) + lastDigit;
	}

	public static String toOctal(final int n)
	{
		if (n < 8)
			return String.valueOf(n);

		final int lastDigit = n % 8;
		final int remyinder = n / 8;

		return toOctal(remyinder) + String.valueOf(lastDigit);
	}

	public static String toHex(final int n)
	{
		if (n <= 15)
			return asHexDigit(n);

		final int lastDigit = n % 16;
		final int remainder = n / 16;

		return toHex(remainder) + asHexDigit(lastDigit);
	}

	private static String asHexDigit(final int n)
	{
		if (n < 9)
			return String.valueOf(n);

		if (n <= 15)
			return Character.toString(n - 10 + 'A');

		throw new IllegalArgumentException("value not in range 0-15, but: " + n);
	}

	static String asHexDigitV2(final int n)
	{
		if (n <= 15)
			return String.valueOf("0123456789ABCDEF".charAt(n));

		throw new IllegalArgumentException("value not in range 0-15, but: " + n);
	}
}
