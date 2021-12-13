package ch03_recursion.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex12_CountSubstringsTest
{
	@ParameterizedTest(name = "countSubstring({0}) = {1}")
	@CsvSource({ "xhixhix, x, 3", "xhixhix, hi, 2", "mic, mic, 1", "haha, ho, 0", "xxxxyz, xx, 2", "xxxx, xx, 2",
		"xx-xxx-xxxx-xxxxx-xxxxxx, xx, 9", "xx-xxx-xxxx-xxxxx-xxxxxx, xxx, 5" })
	void countSubstring(final String input, final String searchFor, final int expected)
	{
		final int result = Ex12_CountSubstrings.countSubstring(input, searchFor);

		assertEquals(expected, result);
	}

	@ParameterizedTest(name = "countSubstringV2({0}) = {1}")
	@CsvSource({ "xhixhix, x, 3", "xhixhix, hi, 2", "mic, mic, 1", "haha, ho, 0", "xxxxyz, xx, 3", "xxxx, xx, 3",
		"xx-xxx-xxxx-xxxxx-xxxxxx, xx, 15", "xx-xxx-xxxx-xxxxx-xxxxxx, xxx, 10" })
	void countSubstringV2(final String input, final String searchFor, final int expected)
	{
		final int result = Ex12_CountSubstrings.countSubstringV2(input, searchFor);

		assertEquals(expected, result);
	}

	@ParameterizedTest(name = "countSubstringShort({0}) = {1}")
	@CsvSource({ "xhixhix, x, 3", "xhixhix, hi, 2", "mic, mic, 1", "haha, ho, 0", "xxxxyz, xx, 3", "xxxx, xx, 3",
		"xx-xxx-xxxx-xxxxx-xxxxxx, xx, 15", "xx-xxx-xxxx-xxxxx-xxxxxx, xxx, 10" })
	void countSubstringShort(final String input, final String searchFor, final int expected)
	{
		final int result = Ex12_CountSubstrings.countSubstringsShort(input, searchFor);

		assertEquals(expected, result);
	}

	@ParameterizedTest(name = "countSubstringOpt({0}) = {1}")
	@CsvSource({ "xhixhix, x, 3", "xhixhix, hi, 2", "mic, mic, 1", "haha, ho, 0", "xxxxyz, xx, 2", "xxxx, xx, 2",
		"xx-xxx-xxxx-xxxxx-xxxxxx, xx, 9", "xx-xxx-xxxx-xxxxx-xxxxxx, xxx, 5" })
	void countSubstringOpt(final String input, final String searchFor, final int expected)
	{
		final int result = Ex12_CountSubstrings.countSubstringOpt(input, searchFor, 0);

		assertEquals(expected, result);
	}

	@ParameterizedTest(name = "countSubstringOpt({0}) = {1}")
	@CsvFileSource(resources = "countsubstringinputs.csv", numLinesToSkip = 1)
	void countSubstringOpt2(final String input, final String searchFor, final int expected)
	{
		final int result = Ex12_CountSubstrings.countSubstringOpt(input, searchFor, 0);

		assertEquals(expected, result);
	}

}
