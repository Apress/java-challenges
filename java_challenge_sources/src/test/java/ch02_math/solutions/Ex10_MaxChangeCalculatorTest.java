package ch02_math.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Example program for the book "Java Challenge"
 *
 * @author Michael Inden
 *
 *         Copyright 2020 by Michael Inden
 */
public class Ex10_MaxChangeCalculatorTest
{
	@ParameterizedTest(name = "calcMaxPossibleChange({0}) = {1}")
	@MethodSource("inputsAndMaxChange")
	public void calcMaxPossibleChange(final List<Integer> values, final int expected)
	{
		final int result = Ex10_MaxChangeCalculator.calcMaxPossibleChange(values);

		assertEquals(expected, result);
	}

	static Stream<Arguments> inputsAndMaxChange()
	{
		return Stream.of(Arguments.of(List.of(1), 1),
				Arguments.of(List.of(1,1), 2),
				Arguments.of(List.of(1, 5), 1),
				Arguments.of(List.of(1, 2, 4), 7),
				Arguments.of(List.of(1, 2, 3, 7), 13),
				Arguments.of(List.of(1, 2, 3, 8), 6),
				Arguments.of(List.of(1, 1, 1, 1, 5, 10, 20, 50), 39));
	}
}
