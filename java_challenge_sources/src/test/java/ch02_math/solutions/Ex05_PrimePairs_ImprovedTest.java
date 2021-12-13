package ch02_math.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
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
public class Ex05_PrimePairs_ImprovedTest
{
	int maxValue = 50;

	@ParameterizedTest(name = "primepairs({0}, {1}) = {2}")
	@MethodSource("distanceAndExpectd")
	void calcPairs(final int distance, final String info, final Map<Integer, Integer> expected)
	{
		final var result = Ex05_PrimePairs_Improved.calcPairs(maxValue, distance);

		assertEquals(expected, result);
	}

	private static Stream<Arguments> distanceAndExpectd()
	{
		return Stream.of(Arguments.of(2, "twin", Map.of(3, 5, 5, 7, 11, 13, 17, 19, 29, 31, 41, 43)),
				Arguments.of(4, "cousin", Map.of(3, 7, 7, 11, 13, 17, 19, 23, 37, 41, 43, 47)),
				Arguments.of(6, "sexy", Map.of(5, 11, 7, 13, 11, 17, 13, 19, 17, 23, 23, 29, 31, 37, 37, 43,
						41, 47, 47, 53)));
	}
}
