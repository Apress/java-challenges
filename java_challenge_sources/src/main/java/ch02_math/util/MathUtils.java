package ch02_math.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
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
public class MathUtils
{
	public static int countDigits(final int number)
	{
		int count = 0;

		int remainingValue = number;
		while (remainingValue > 0)
		{
			remainingValue = remainingValue / 10;
			count++;
		}

		return count;
	}

	public static int calcPowOfTen(final int number)
	{
		return countDigits(number) - 1;
	}

	public static List<Integer> findProperDivisors(final int value)
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

	public static boolean isEven(final int n)
	{
		return n % 2 == 0;
	}

	public static boolean isOdd(final int n)
	{
		return n % 2 != 0;
	}

	public static int minOf3(final int x, final int y, final int z)
	{
		return Math.min(x, Math.min(y, z));
	}

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

	public static boolean isPerfectNumber(final int number)
	{
		final List<Integer> divisors = findProperDivisors(number);

		return divisors.stream().mapToInt(n -> n).sum() == number;
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

	private static List<Integer> buildPrimesList(final boolean[] isPotentiallyPrime)
	{
		final List<Integer> primes = new ArrayList<>();
		for (int i = 2; i < isPotentiallyPrime.length; i++)
		{
			if (isPotentiallyPrime[i])
				primes.add(i);
		}
		return primes;
	}

	public static List<Integer> calcPrimeFactors(final int n)
	{
		final List<Integer> allPrimes = calcPrimesUpTo(n);

		final List<Integer> primeFactors = new ArrayList<>();

		int remainingValue = n;
		while (remainingValue > 1)
		{
			for (final Integer currentPrime : allPrimes)
			{
				while (remainingValue % currentPrime == 0)
				{
					remainingValue = remainingValue / currentPrime;
					primeFactors.add(currentPrime);
				}
			}
		}
		return primeFactors;
	}

	private static void eraseMultiplesOfCurrent(final boolean[] isPotentiallyPrime, final int i)
	{
		for (int n = i + i; n < isPotentiallyPrime.length; n = n + i)
		{
			isPotentiallyPrime[n] = false;
			// System.out.println("Eliminating " + n);
		}
	}

	private static Map<Character, Integer> valueMap = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M',
			1000);

	public static int fromRomanNumber(final String romanNumber)
	{
		int value = 0;
		int lastDigitValue = 0;

		for (int i = romanNumber.length() - 1; i >= 0; i--)
		{
			final char romanDigit = romanNumber.charAt(i);
			final int digitValue = valueMap.getOrDefault(romanDigit, 0);

			final boolean addMode = digitValue >= lastDigitValue;
			if (addMode)
			{
				value += digitValue;
				lastDigitValue = digitValue;
			}
			else
			{
				value -= digitValue;
			}
		}
		return value;
	}

	public static String toRomanNumber(final int value)
	{
		String result = "";
		int reminder = value;

		// descending order
		final Comparator<Integer> reversed = Comparator.reverseOrder();
		final Map<Integer, String> sortedIntToRomanDigit = new TreeMap<>(reversed);
		sortedIntToRomanDigit.putAll(intToRomanDigitMap);

		// start with highest value
		final Iterator<Map.Entry<Integer, String>> it = sortedIntToRomanDigit.entrySet().iterator();
		while (it.hasNext() && reminder > 0)
		{
			final Map.Entry<Integer, String> entry = it.next();
			final String romanDigitCombi = entry.getValue();

			final int multiplier = entry.getKey();
			final int times = reminder / multiplier;
			reminder = reminder % multiplier;

			result += romanDigitCombi.repeat(times);
		}

		return result;
	}

	private static Map<Integer, String> intToRomanDigitMap = new TreeMap<>()
	{
		{
			put(1, "I");
			put(4, "IV");
			put(5, "V");
			put(9, "IX");
			put(10, "X");
			put(40, "XL");
			put(50, "L");
			put(90, "XC");
			put(100, "C");
			put(400, "CD");
			put(500, "D");
			put(900, "CM");
			put(1000, "M");
		}
	};
}
