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
public class Ex07_NumberConversionsTest
{
	@ParameterizedTest(name = "toBinary({0}) => {1}")
	@CsvSource({ "5, 101", "7, 111", "22, 10110", "42, 101010", "256, 100000000" })
	void toBinary(final int value, final String expected)
	{
		final String result = Ex07_NumberConversions.toBinary(value);

		assertEquals(expected, result);
	}

	@ParameterizedTest(name = "toOctal({0}) => {1}")
	@CsvSource({ "42, 52", "7, 7", "8, 10" })
	void toOctal(final int value, final String expected)
	{
		final String result = Ex07_NumberConversions.toOctal(value);

		assertEquals(expected, result);
	}

	@ParameterizedTest(name = "toHex({0}) => {1}")
	@CsvSource({ "77, 4D", "15, F", "16, 10" })
	void toHex(final int value, final String expected)
	{
		final String result = Ex07_NumberConversions.toHex(value);

		assertEquals(expected, result);
	}
}
