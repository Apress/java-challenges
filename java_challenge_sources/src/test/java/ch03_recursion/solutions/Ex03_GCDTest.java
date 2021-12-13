package ch03_recursion.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex03_GCDTest
{
	@ParameterizedTest(name = "gcd({0}, {1}) = {2}")
	@CsvSource({ "42, 7, 7", "42, 28, 14", "42, 14, 14" })
	public void gcd(final int a, final int b, final int expected)
	{
		final int result = Ex03_GCD.gcd(a, b);

		assertEquals(expected, result);
	}

	@ParameterizedTest(name = "gcdIterative({0}, {1}) = {2}")
	@CsvSource({ "42, 7, 7", "42, 28, 14", "42, 14, 14" })
	public void gcdIterative(final int a, final int b, final int expected)
	{
		final int result = Ex03_GCD.gcdIterative(a, b);

		assertEquals(expected, result);
	}

	@ParameterizedTest(name = "lcm({0}, {1}) = {2}")
	@CsvSource({ "2, 7, 14", "7, 14, 14", "42, 14, 42" })
	public void lcm(final int a, final int b, final int expected)
	{
		final int result = Ex03_GCD.lcm(a, b);

		assertEquals(expected, result);
	}
}
