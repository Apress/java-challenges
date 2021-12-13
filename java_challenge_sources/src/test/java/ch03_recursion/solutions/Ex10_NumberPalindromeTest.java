package ch03_recursion.solutions;

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
public class Ex10_NumberPalindromeTest
{
	@ParameterizedTest(name = "isNumberPalindrome({0}) => {1}")
	@CsvSource({ "7, true", "13, false", "171, true", "47742, false", "123321, true", "1234554321, true" })
	void isNumberPalindrome(final int number, final boolean expected)
	{
		final boolean result = Ex10_NumberPalindrome.isNumberPalindrome(number);

		assertEquals(expected, result);
	}

	@ParameterizedTest(name = "isNumberPalindromeRec({0}) => {1}")
	@CsvSource({ "7, true", "13, false", "171, true", "47742, false", "123321, true", "1234554321, true" })
	void isNumberPalindromeRec(final int number, final boolean expected)
	{
		final boolean result = Ex10_NumberPalindrome.isNumberPalindromeRec(number);

		assertEquals(expected, result);
	}
}
