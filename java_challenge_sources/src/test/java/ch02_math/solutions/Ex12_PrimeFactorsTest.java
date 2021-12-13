package ch02_math.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
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
public class Ex12_PrimeFactorsTest
{
	@ParameterizedTest(name = "calcPrimeFactors({0}) = {1}")
	@MethodSource("valueAndPrimeFactors")
	void calcPrimeFactors(final int value, final List<Integer>  expected)
	{
		final var result = Ex12_PrimeFactors.calcPrimeFactors(value);

		assertEquals(expected, result);
	}

	@ParameterizedTest(name = "calcPrimeFactorsOptimized({0}) = {1}")
	@MethodSource("valueAndPrimeFactors")
	void calcPrimeFactorsOpt(final int value, final List<Integer> expected)
	{
		final var result = Ex12_PrimeFactors.calcPrimeFactorsOptimized(value);

		assertEquals(expected, result);
	}

	private static Stream<Arguments> valueAndPrimeFactors()
	{
		return Stream.of(Arguments.of(8, List.of(2, 2, 2)),
				Arguments.of(14, List.of(2, 7)),
				Arguments.of(42, List.of(2, 3, 7)),
				Arguments.of(1155, List.of(3, 5, 7, 11)),
				Arguments.of(2002, List.of(2, 7, 11, 13)),
				Arguments.of(2222, List.of(2, 11, 101)),
				Arguments.of(2310, List.of(2, 3, 5, 7, 11)),
				Arguments.of(33558, List.of(2, 3, 7, 17, 47)));
	}
}
