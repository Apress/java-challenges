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
public class Ex08_ExponentationTest
{
	@ParameterizedTest(name = "isPowerOf2({0}) => {1}")
	@CsvSource({ "2, true", "3, false", "4, true", "10, false", "16, true" })
	void isPowerOf2(final int number, final boolean expected)
	{
		final boolean result = Ex08_Exponentation.isPowerOf2(number);

		assertEquals(expected, result);
	}

	@ParameterizedTest(name = "isPowerOf2Short({0}) => {1}")
	@CsvSource({ "2, true", "3, false", "4, true", "10, false", "16, true" })
	void isPowerOf2Short(final int number, final boolean expected)
	{
		final boolean result = Ex08_Exponentation.isPowerOf2Short(number);

		assertEquals(expected, result);
	}

	@ParameterizedTest(name = "powerOf({0}) => {1}")
	@CsvSource({ "2, 2, 4", "4, 2, 16", "16, 2, 256", "4, 4, 256", "2, 8, 256" })
	void powerOf(final int number, final int exponent, final long expected)
	{
		final long result = Ex08_Exponentation.powerOf(number, exponent);

		assertEquals(expected, result);
	}

	@ParameterizedTest(name = "powerOfIterative({0}) => {1}")
	@CsvSource({ "2, 2, 4", "4, 2, 16", "16, 2, 256", "4, 4, 256", "2, 8, 256" })
	void powerOfIterative(final int number, final int exponent, final long expected)
	{
		final long result = Ex08_Exponentation.powerOfIterative(number, exponent);

		assertEquals(expected, result);
	}

	@ParameterizedTest(name = "powerOfOptimized({0}) => {1}")
	@CsvSource({ "2, 2, 4", "4, 2, 16", "16, 2, 256", "4, 4, 256", "2, 8, 256" })
	void powerOfOptimized(final int number, final int exponent, final long expected)
	{
		final long result = Ex08_Exponentation.powerOfOptimized(number, exponent);

		assertEquals(expected, result);
	}
}
