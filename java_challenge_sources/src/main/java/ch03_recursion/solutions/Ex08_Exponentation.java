package ch03_recursion.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex08_Exponentation
{
	private Ex08_Exponentation()
	{
	}

	public static boolean isPowerOf2(final int n)
	{
		if (n < 2)
			return n == 1;

		if (n % 2 != 0)
			return false;

		return isPowerOf2(n / 2);
	}

	static boolean isPowerOf2Short(final int n)
	{
		return n == 1 || n > 0 && n % 2 == 0 && isPowerOf2(n / 2);
	}

	// Algorithm: Call the method exponent - 1 times by itself and
	// multiply the number by the result of the self call,
	// Reduce the exponent at each call and terminate at exponent 1 or 0.
	public static long powerOf(final int value, final int exponent)
	{
		if (exponent < 0)
			throw new IllegalArgumentException("exponent must be >= 0");

		if (exponent == 0)
			return 1;

		if (exponent == 1)
			return value;

		return value * powerOf(value, exponent - 1);
	}

	static long powerOfOptimized(final long value, final int exponent)
	{
		if (exponent < 0)
			throw new IllegalArgumentException("exponent must be >= 0");

		// recursive termination
		if (exponent == 0)
			return 1;

		if (exponent == 1)
			return value;

		// recursive descent
		long result = powerOfOptimized(value * value, exponent / 2);
		if (exponent % 2 == 1)
			return value * result;

		return result;
	}

	static long powerOfIterative(int value, int exponent)
	{
		if (exponent == 0)
			return 1;

		if (exponent == 1)
			return value;

		long result = 1;
		while (exponent > 0)
		{
			result *= value;
			exponent--;
		}

		return result;
	}
}
