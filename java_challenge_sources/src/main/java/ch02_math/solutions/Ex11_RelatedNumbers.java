package ch02_math.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Example program for the book "Java Challenge"
 *
 * @author Michael Inden
 *
 *         Copyright 2020 by Michael Inden
 */
public class Ex11_RelatedNumbers
{
	private Ex11_RelatedNumbers()
	{
	}

	static Map<Integer, Integer> calcFriends(final int max) {
		final Map<Integer, Integer> friends = new TreeMap<>();

		for (int number = 2; number < max; number++) {
			final List<Integer> divisors1 = findProperDivisors(number);
			final int sumDiv1 = sum(divisors1);

			final List<Integer> divisors2 = findProperDivisors(sumDiv1);
			final int sumDiv2 = sum(divisors2);

			if (number == sumDiv2 && sumDiv1 != sumDiv2) {
				friends.put(number, sumDiv1);
			}
		}

		return friends;
	}


	private static int sum(final List<Integer> values)
	{
		return values.stream().mapToInt(n->n).sum();
	}

	private static List<Integer> findProperDivisors(final int value)
	{
		final List<Integer> divisors = new ArrayList<>();

		for (int i = 1; i <= value / 2; i++)
		{
			if (value % i == 0)
			{
				divisors.add(i);
			}
		}

		return divisors;
	}
}
