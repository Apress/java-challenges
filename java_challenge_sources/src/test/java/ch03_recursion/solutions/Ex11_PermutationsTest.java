package ch03_recursion.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
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
public class Ex11_PermutationsTest
{
	@ParameterizedTest(name = "calcPermutations({0}) = {1}")
	@MethodSource("inputAndPermutations")
	void calcPermutations(final String input, final Set<String> expected)
	{
		final Set<String> result = Ex11_Permutations.calcPermutations(input);

		assertEquals(expected, result);
	}

	@ParameterizedTest(name = "calcPermutationsMiniOpt({0}) = {1}")
	@MethodSource("inputAndPermutations")
	void calcPermutationsMiniOpt(final String input, final Set<String> expected)
	{
		final Set<String> result = Ex11_Permutations.calcPermutationsMiniOpt(input);

		assertEquals(expected, result);
	}

	private static Stream<Arguments> inputAndPermutations()
	{
		return Stream.of(Arguments.of("A", Set.of("A")),
				Arguments.of("AA", Set.of("AA")),
				Arguments.of("AB", Set.of("AB", "BA")),
				Arguments.of("ABC", Set.of("ABC", "BAC", "ACB",
						"CAB", "CBA", "BCA")),
				Arguments.of("AAC", Set.of("AAC", "ACA", "CAA")));
	}
}
