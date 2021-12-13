package ch02_math.intro;

import java.util.ArrayList;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class PrimeNumberChecker
{
	public static boolean isPrime(final int potentiallyPrime)
	{
		// check for all relevant numbers if they represent a divisor
		for (int i = 2; i <= potentiallyPrime / 2; i++)
		{
			if (potentiallyPrime % i == 0)
			{
				return false;
			}
		}
		return true;
	}

	public static void main(final String[] args)
	{
		System.out.println(isPrime(4));
		System.out.println(isPrime(7));
		System.out.println(isPrime(42));

		var primes = new ArrayList<>();
		for (int i = 2; i < 25; i++)
		{
			if (isPrime(i))
				primes.add(i);
		}
		System.out.println("Primes < 25:" + primes);
	}
}