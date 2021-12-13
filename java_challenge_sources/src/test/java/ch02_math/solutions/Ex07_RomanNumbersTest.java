package ch02_math.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
public class Ex07_RomanNumbersTest
{
	@ParameterizedTest(name = "fromRomanNumber(''{1}'') => {0}")
	@CsvSource({ "1, I", "2, II", "3, III", "4, IV", "5, V", "7, VII", "9, IX",
		"17, XVII", "40, XL", "90, XC", "400, CD", "444, CDXLIV", "500, D",
		"900, CM", "1000, M", "1666, MDCLXVI", "1971, MCMLXXI",
		"2018, MMXVIII", "2019, MMXIX", "2020, MMXX", "3000, MMM"})
	@DisplayName("Convert Arabic number to Roman numerals")
	void fromRomanNumber(final int arabicNumber, final String romanNumber)
	{
		final int result = Ex07_RomanNumbers.fromRomanNumber(romanNumber);

		assertEquals(arabicNumber, result);
	}

	@Test
	void fromRomanNumberWrongInput()
	{
		final int result = Ex07_RomanNumbers.fromRomanNumber("IXD");

		assertEquals(489, result);
	}


	@ParameterizedTest(name = "toRomanNumber(''{0}'') => {1}")
	@CsvSource({ "1, I", "2, II", "3, III", "4, IV", "5, V", "7, VII", "9, IX", "17, XVII", "40, XL", "90, XC",
		"400, CD", "444, CDXLIV", "500, D", "900, CM", "1000, M", "1666, MDCLXVI", "1971, MCMLXXI",
		"2018, MMXVIII", "2019, MMXIX", "2020, MMXX", "3000, MMM" })
	void toRomanNumber(final int arabicNumber, final String romanNumber)
	{
		final String result = Ex07_RomanNumbers.toRomanNumber(arabicNumber);

		assertEquals(romanNumber, result);
	}

	@ParameterizedTest(name = "toRomanNumber(''{0}'') => {1}")
	@CsvFileSource(resources = "arabicroman.csv", numLinesToSkip = 1)
	@DisplayName("Convert Arabic number to Roman numerals")
	void toRomanNumberCsvInput(final int arabicNumber, final String romanNumber)
	{
		final String result = Ex07_RomanNumbers.toRomanNumber(arabicNumber);

		assertEquals(romanNumber, result);
	}
}
