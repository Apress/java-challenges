package ch03_recursion.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex05_ArraySumTest
{
	@ParameterizedTest(name="sum({0}) = {1}")
	@MethodSource("valuesAndResult")
	void sum(final int[] values, final int expected)
	{
		final int result = Ex05_ArraySum.sum(values);

		assertEquals(expected, result);
	}

	@ParameterizedTest(name = "sumV2({0}) = {1}")
	@MethodSource("valuesAndResult")
	void sumV2(final int[] values, final int expected)
	{
		final int result = Ex05_ArraySum.sumV2(values);

		assertEquals(expected, result);
	}

	private static Stream<Arguments> valuesAndResult()
	{
		return Stream.of(Arguments.of(new int[] { 1 }, 1),
				Arguments.of(new int[] { 1, 2, 3 }, 6),
				Arguments.of(new int[] { 1, 2, 3, -7 }, -1));
	}
}
