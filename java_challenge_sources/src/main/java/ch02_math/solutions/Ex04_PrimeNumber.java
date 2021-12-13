package ch02_math.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex04_PrimeNumber
{
	private Ex04_PrimeNumber()
	{
	}

	public static List<Integer> calcPrimesUpTo(final int maxValue)
	{
		// initially mark all values as potential prime number
		final boolean[] isPotentiallyPrime = new boolean[maxValue + 1];
		Arrays.fill(isPotentiallyPrime, true);

		// run through all numbers starting at 2, optimization only up to half
		for (int i = 2; i <= maxValue / 2; i++)
		{
			if (isPotentiallyPrime[i])
			{
				// "erase" all multiples (always increase by the current number)
				eraseMultiplesOfCurrent(isPotentiallyPrime, i);
			}
		}

		// Get result ==> could be done directly in the loop above, but would be less
		// readable
		return buildPrimesList(isPotentiallyPrime);
	}

	static List<Integer> buildPrimesList(final boolean[] isPotentiallyPrime)
	{
		final List<Integer> primes = new ArrayList<>();
		for (int i = 2; i < isPotentiallyPrime.length; i++)
		{
			if (isPotentiallyPrime[i])
				primes.add(i);
		}
		return primes;
	}

	private static void eraseMultiplesOfCurrent(final boolean[] isPotentiallyPrime, final int i)
	{
		for (int n = i + i; n < isPotentiallyPrime.length; n = n + i)
		{
			isPotentiallyPrime[n] = false;
			// System.out.println("Eliminating " + n);
		}
	}
}
