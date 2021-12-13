package ch02_math.solutions;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex05_PrimePairs
{
	private Ex05_PrimePairs()
	{
	}

	public static void main(final String[] args)
	{
		final Predicate<Integer> isTwinPair = n -> isPrime(n) && isPrime(n+2);
		final Predicate<Integer> isCousinPair = n -> isPrime(n) && isPrime(n+4);
		final Predicate<Integer> isSexyPair = n -> isPrime(n) && isPrime(n+6);

		final Map<Integer, Integer> twins = new TreeMap<>();
		final Map<Integer, Integer> cousins = new TreeMap<>();
		final Map<Integer, Integer> sexy = new TreeMap<>();

		for (int i = 1; i < 50; i++)
		{
			if (isTwinPair.test(i))
				twins.put(i, i+2);

			if (isCousinPair.test(i))
				cousins.put(i, i+4);

			if (isSexyPair.test(i))
				sexy.put(i, i+6);
		}

		printNicely("Twins: ", twins);
		printNicely("Cousins: ", cousins);
		printNicely("Sexy: ", sexy);
	}


	private static boolean isPrime(final int n)
	{
		// call is not optimal
		return Ex04_PrimeNumber.calcPrimesUpTo(n).contains(n);
	}

	static void printNicely(final String info,
			final Map<Integer,Integer> map)
	{
		System.out.print(info);
		map.forEach((k, v) -> System.out.print("" + k + " & " + v + " // "));
		System.out.println();
	}
}
