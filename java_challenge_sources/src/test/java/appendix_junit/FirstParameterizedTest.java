package appendix_junit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class FirstParameterizedTest
{
	@ParameterizedTest(name = "run {index}: ''{0}'' is not empty")
	@ValueSource(strings = { "Tim", "Tom", "", "Mike" })
	void isNotEmpty(final String value)
	{
		assertFalse(value.isEmpty());
	}

	@ParameterizedTest(name = "run {index}: {0} is a prime")
	@ValueSource(ints = { 1, 2, 3, 4, 5, 6, 7 })
	void ensureIsPrime(final int value)
	{
		assertTrue(MathUtils.isPrime(value));
	}

	static class MathUtils
	{
		public static boolean isPrime(final int n)
		{
			if (n <= 1)
			{
				return false;
			}
			if (n == 2)
			{
				return true;
			}

			for (int i = 2; i < n; i++)
			{

				if (n % i == 0)
				{
					return false;
				}
			}
			return true;
		}
	}
}
