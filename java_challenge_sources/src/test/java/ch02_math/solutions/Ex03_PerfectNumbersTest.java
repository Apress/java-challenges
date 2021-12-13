package ch02_math.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex03_PerfectNumbersTest
{
	@ParameterizedTest(name = "{0} should be perfect")
	@ValueSource(ints = { 6, 28, 496, 8128 } )
	void isPerfectNumberSimple(final int value)
	{
		final boolean result = Ex03_PerfectNumbers.isPerfectNumberSimple(value);

		assertTrue(result);
	}

	@ParameterizedTest(name = "{0} should be perfect")
	@ValueSource(ints = { 6, 28, 496, 8128 })
	void isPerfectNumberBasedOnProperDivisors(final int value)
	{
		final boolean result = Ex03_PerfectNumbers.isPerfectNumberBasedOnProperDivisors(value);

		assertTrue(result);
	}

	@ParameterizedTest(name = "calcPerfectNumbers({0}) = {1}")
	@MethodSource("maxAndPerfectNumbers")
	void calcPerfectNumbers(final int maxExclusive, final List<Integer> expected)
	{
		final List<Integer> result = Ex03_PerfectNumbers.calcPerfectNumbers(maxExclusive);

		assertEquals(expected, result);
	}

	@ParameterizedTest(name = "calPerfectNumbersStreamBased({0}) = {1}")
	@MethodSource("maxAndPerfectNumbers")
	void calPerfectNumbersStreamBased(final int maxExclusive, final List<Integer> expected)
	{
		final List<Integer> result = Ex03_PerfectNumbers.calcPerfectNumbersStreamBased(maxExclusive);

		assertEquals(expected, result);
	}

	static Stream<Arguments> maxAndPerfectNumbers()
	{
		return Stream.of(Arguments.of(1000, List.of(6, 28, 496)),
				Arguments.of(10000, List.of(6, 28, 496, 8128)));
	}
}
