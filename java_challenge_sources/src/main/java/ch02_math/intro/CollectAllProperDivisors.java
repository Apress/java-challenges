package ch02_math.intro;

import java.util.ArrayList;
import java.util.List;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class CollectAllProperDivisors
{
	public static void main(final String[] args)
	{
		System.out.println(findProperDivisors(6));
		System.out.println(findProperDivisors(24));
		System.out.println(findProperDivisors(7));
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
