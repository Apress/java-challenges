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
public class Ex04_ReverseStringTest
{
	@ParameterizedTest(name = "reverseString({0}) => {1}")
	@CsvSource({ "A, A", "ABC, CBA", "abcdefghi, ihgfedcba" })
	public void reverseString(String input, String expected)
	{
		String result = Ex04_ReverseString.reverseString(input);

		assertEquals(expected, result);
	}

	@ParameterizedTest(name = "reverseStringShort({0}) => {1}")
	@CsvSource({ "A, A", "ABC, CBA", "abcdefghi, ihgfedcba" })
	public void reverseStringShort(String input, String expected)
	{
		String result = Ex04_ReverseString.reverseStringShort(input);

		assertEquals(expected, result);
	}
}
