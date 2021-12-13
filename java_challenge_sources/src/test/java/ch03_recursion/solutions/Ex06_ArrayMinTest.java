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
public class Ex06_ArrayMinTest
{
	@ParameterizedTest(name="min({0}) = {1}")
	@MethodSource("valuesAndMinimum")
	void min(final int[] input, final int expected)
	{
		final int result = Ex06_ArrayMin.min(input);

		assertEquals(expected, result);
	}

	private static Stream<Arguments> valuesAndMinimum()
	{
		return Stream.of(Arguments.of(new int[] { 7, 2, 1, 9, 7, 1 }, 1),
				Arguments.of(new int[] { 11, 2, 33, 44, 55, 6, 7 }, 2),
				Arguments.of(new int[] { 1, 2, 3, -7 }, -7),
				Arguments.of(new int[] { }, Integer.MAX_VALUE));
	}
}
