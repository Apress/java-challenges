package ch03_recursion.intro;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class CallHierarchyExample
{
	public static void main(final String[] args)
	{
		System.out.println(calcMultOfDigits(1234));
		System.out.println(calcMultOfDigits(257));

		System.out.println(sum(5));

		// System.out.println(sum(15000));// StackOverflowError
	}

	public static int calcMultOfDigits(final int value)
	{
		final int remainder = value / 10;
		final int digitValue = value % 10;

		System.out.printf("calcMultOfDigits: %-10d | remainder: %d, digit: %d%n",
				value, remainder, digitValue);

		if (remainder > 0)
		{
			final int result = calcMultOfDigits(remainder);

			System.out.printf("-> %d * %d = %d%n",
					digitValue, result, digitValue * result);
			return digitValue * result;
		}
		else
		{
			System.out.println("-> " + value);
			return value;
		}
	}

	public static int sum(final int n)
	{
		if (n <= 0)
			throw new IllegalArgumentException("n must be >= 1");

		if (n == 1)
			return 1;

		final int sum_1 = sum(n - 1);
		System.out.printf("sum(%d) = %d%n", n-1, sum_1);

		final int result = n + sum_1;
		System.out.printf("%d + sum(%d) -> %-10d%n", n, n-1, result);

		return result;
	}
}
