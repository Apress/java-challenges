package ch03_recursion.intro;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class InfiniteRecursionExample
{
	public static void main(final String[] args)
	{
		final int length = calcLengthParameterValues("AABCDE", 0);
		System.out.println("length: " + length);

		//factorialNoAbortion(21000);
		System.out.println("factorial");
	}

	static int calcLengthParameterValues(final String value, final int count)
	{
		if (value.length() == 0)
			return count;

		System.out.println("Count: " + count);
		String remaining = value.substring(1);

		return calcLengthParameterValues(remaining, count + 1);
	}

	public static int factorialNoAbortion(final int number)
	{
		return number * factorialNoAbortion(number - 1);
	}

	public static int factorialWrongCall(final int n)
	{
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;

		return factorialWrongCall(n) * n;
	}
}
