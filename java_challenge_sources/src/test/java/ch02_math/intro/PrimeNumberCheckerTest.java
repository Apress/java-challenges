package ch02_math.intro;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class PrimeNumberCheckerTest
{
	@Test
	public void testIsPrime() throws Exception
	{
		assertTrue(PrimeNumberChecker.isPrime(7));
	}

	@Test
	public void testIsNoPrime() throws Exception
	{
		assertFalse(PrimeNumberChecker.isPrime(42));
	}

	@ParameterizedTest(name = "value at pos {index} ==> {0} should be a prime")
	@ValueSource(ints = { 2, 3, 5, 7, 11, 13, 17, 19 })
	void palindromes(int value) {
		assertTrue(PrimeNumberChecker.isPrime(value));
	}
}
