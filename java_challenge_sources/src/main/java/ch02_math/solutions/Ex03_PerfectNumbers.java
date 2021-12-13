package ch02_math.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import ch02_math.util.MathUtils;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex03_PerfectNumbers
{
	private Ex03_PerfectNumbers()
	{
	}

	static List<Integer> calcPerfectNumbers(final int maxExclusive)
	{
		final List<Integer> results = new ArrayList<>();

		for (int i = 2; i < maxExclusive; i++)
		{
			if (isPerfectNumberSimple(i))
				results.add(i);
		}

		return results;
	}

	static List<Integer> calcPerfectNumbersStreamBased(final int maxExclusive)
	{
		return IntStream.range(2, maxExclusive).
				filter(i -> isPerfectNumberSimple(i)).mapToObj(i -> i).toList();
	}

	static boolean isPerfectNumberSimple(final int number)
	{
		// always divisible by 1
		int sumOfMultipliers = 1;

		for (int i = 2; i <= number / 2; i++)
		{
			if (number % i == 0)
			{
				sumOfMultipliers += i;
			}
		}

		return sumOfMultipliers == number;
	}

	static boolean isPerfectNumberBasedOnProperDivisors(final int number)
	{
		final List<Integer> divisors = MathUtils.findProperDivisors(number);

		return divisors.stream().mapToInt(n -> n).sum() == number;
	}
}
