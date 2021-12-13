package ch03_recursion.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.function.Consumer;
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
public class Ex09_PascalTriangleTest
{
	@ParameterizedTest(name = "calcPascal({0}) = {1}")
	@MethodSource("valuesAndResults")
	void calcPascal(final int n, final List<Integer> expected)
	{
		final Consumer<List<Integer>> NOOP = whatever -> {
		};
		final List<Integer> result = Ex09_PascalTriangle.calcPascal(n, NOOP);

		assertEquals(expected, result);
	}

	private static Stream<Arguments> valuesAndResults()
	{
		return Stream.of(Arguments.of(1, List.of(1)),
				Arguments.of(2, List.of(1,1)),
				Arguments.of(3, List.of(1,2,1)),
				Arguments.of(4, List.of(1,3,3,1)),
				Arguments.of(5, List.of(1,4,6,4,1)));
	}
}
