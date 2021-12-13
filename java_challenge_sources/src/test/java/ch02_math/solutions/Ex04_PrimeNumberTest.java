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
public class Ex04_PrimeNumberTest
{
	@ParameterizedTest(name = "calcPrimes({0}) = {1}")
	@MethodSource("argumentProvider")
	public void testCalcPrimesBelow(final int n, final List<Integer> expected) throws Exception
	{
		final List<Integer> result = Ex04_PrimeNumber.calcPrimesUpTo(n);

		assertEquals(expected, result);
	}

	static Stream<Arguments> argumentProvider()
	{
		return Stream.of(Arguments.of(2, List.of(2)),
				Arguments.of(3, List.of(2, 3)),
				Arguments.of(10, List.of(2, 3, 5, 7)),
				Arguments.of(15, List.of(2, 3, 5, 7, 11, 13)),
				Arguments.of(25, List.of(2, 3, 5, 7, 11, 13,
						17, 19, 23)),
				Arguments.of(50, List.of(2, 3, 5, 7, 11, 13,
						17, 19, 23, 29, 31,
						37, 41, 43, 47)));
	}
}
