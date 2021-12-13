package ch02_math.solutions;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex05_PrimePairs_Improved
{
	private Ex05_PrimePairs_Improved()
	{
	}

	static boolean isPrime(final List<Integer> primes, final int n)
	{
		return primes.contains(n);
	}

	public static void calcPrimePairsImproved(final int maxValue)
	{
		final Map<Integer, Integer> twinPairs = calcPairs(maxValue, 2);
		final Map<Integer, Integer> cousinsPairs = calcPairs(maxValue, 4);
		final Map<Integer, Integer> sexyPairs = calcPairs(maxValue, 6);

		System.out.println("Twins: " + twinPairs);
		System.out.println("Cousins: " + cousinsPairs);
		System.out.println("Sexy: " + sexyPairs);
	}

	static Map<Integer, Integer> calcPairs(final int maxValue, final int distance)
	{
		final List<Integer> primes = Ex04_PrimeNumber.calcPrimesUpTo(maxValue + distance);

		final Map<Integer, Integer> resultPairs = new TreeMap<>();
		for (int n = 1; n < maxValue; n++)
		{
			if (isPrime(primes, n) && isPrime(primes, n + distance))
			{
				resultPairs.put(n, n + distance);
			}
		}
		return resultPairs;
	}
}
