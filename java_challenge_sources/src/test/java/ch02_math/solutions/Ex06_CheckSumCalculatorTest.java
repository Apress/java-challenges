package ch02_math.solutions;

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
public class Ex06_CheckSumCalculatorTest
{
	@ParameterizedTest(name = "checksum({0}) = {1}")
	@CsvSource({ "11111, 5", "22222, 0", "111111, 1", "12345678, 4", "87654321, 0" })
	void testCalcChecksum(String input, int expected)
	{
		final int result = Ex06_CheckSumCalculator.calcChecksum(input);

		assertEquals(expected, result);
	}
}
