package ch02_math.solutions;

import java.util.Map;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex02_NumberAsText
{
	private Ex02_NumberAsText()
	{
	}

	static Map<Integer, String> valueToTextMap = Map.of(0, "ZERO",
			1, "ONE", 2, "TWO", 3, "THREE", 4, "FOUR", 5, "FIVE",
			6, "SIX", 7, "SEVEN", 8, "EIGHT", 9, "NINE");


	static String digitAsText(int n)
	{
		int reminder = n % 10;

		return valueToTextMap.getOrDefault(reminder, "-?-");
	}

	static String numberAsText(final int n)
	{
		String value = "";
		int remainingValue = n;
		while (remainingValue > 0)
		{
			var reminder = remainingValue % 10;
			var reminderAsText = digitAsText(reminder);
			value = reminderAsText + " " + value;

			remainingValue /= 10;
		}

		return value.trim();
	}
}
