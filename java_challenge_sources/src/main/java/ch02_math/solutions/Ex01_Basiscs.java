package ch02_math.solutions;

import java.util.Map;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex01_Basiscs
{
	private Ex01_Basiscs()
	{
	}

	static int calc(final int n, final int m)
	{
		return n * m / 2 % 7;
	}

	static void calcSumAndCountAllNumbersDivBy_2_Or_7_Simple(final int max)
	{
		int count = 0;
		int sum = 0;

		for (int i = 1; i < max; i++)
		{
			final boolean divisibleBy2or7 = i % 2 == 0 || i % 7 == 0;
			if (divisibleBy2or7)
			{
				count++;
				sum += i;
			}
		}

		System.out.println("count: " + count);
		System.out.println("sum: " + sum);
	}

	enum ReturnCode {
		SUM, COUNT
	}

	public static Map<ReturnCode, Integer> calcSumAndCountAllNumbersDivBy_2_Or_7(final int max)
	{
		int count = 0;
		int sum = 0;

		for (int i = 1; i < max; i++)
		{
			final boolean divisibleBy2or7 = i % 2 == 0 || i % 7 == 0;
			if (divisibleBy2or7)
			{
				System.out.println(i);
				count++;
				sum += i;
			}
		}

		return Map.of(ReturnCode.SUM, sum, ReturnCode.COUNT, count);
	}

	static boolean isEven(final int n)
	{
		return n % 2 == 0;
	}

	static boolean isOdd(final int n)
	{
		return n % 2 != 0;
	}
}
