package ch02_math.solutions;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex07_RomanNumbers
{
	private Ex07_RomanNumbers()
	{
	}

	static Map<Character, Integer> valueMap = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

	public static int fromRomanNumber(final String romanNumber)
	{
		int value = 0;
		int lastDigitValue = 0;

		for (int i = romanNumber.length() - 1; i >= 0; i--)
		{
			final char romanDigit = romanNumber.charAt(i);
			final int digitValue = valueMap.getOrDefault(romanDigit, 0);

			final boolean addMode = digitValue >= lastDigitValue;
			if (addMode)
			{
				value += digitValue;
				lastDigitValue = digitValue;
			}
			else
			{
				value -= digitValue;
			}
		}
		return value;
	}

	public static String toRomanNumber(final int value)
	{
		String result = "";
		int reminder = value;

		// descending order
		final Comparator<Integer> reversed = Comparator.reverseOrder();
		final Map<Integer, String> sortedIntToRomanDigit = new TreeMap<>(reversed);
		sortedIntToRomanDigit.putAll(intToRomanDigitMap);

		// start with highest value
		final Iterator<Map.Entry<Integer, String>> it = sortedIntToRomanDigit.entrySet().iterator();
		while (it.hasNext() && reminder > 0)
		{
			final Map.Entry<Integer, String> entry = it.next();
			final String romanDigitCombi = entry.getValue();

			final int multiplier = entry.getKey();
			final int times = reminder / multiplier;
			reminder = reminder % multiplier;

			result += romanDigitCombi.repeat(times);
		}

		return result;
	}

	static Map<Integer, String> intToRomanDigitMap = new TreeMap<>()
	{
		{
			put(1, "I");
			put(4, "IV");
			put(5, "V");
			put(9, "IX");
			put(10, "X");
			put(40, "XL");
			put(50, "L");
			put(90, "XC");
			put(100, "C");
			put(400, "CD");
			put(500, "D");
			put(900, "CM");
			put(1000, "M");
		}
	};
}
