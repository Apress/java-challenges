package ch03_recursion.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex04_ReverseString
{
	private Ex04_ReverseString()
	{
	}

	static String reverseString(final String input)
	{
		if (input.length() <= 1)
			return input;

		final char firstChar = input.charAt(0);
		final String remaining = input.substring(1);

		return reverseString(remaining) + firstChar;
	}

	static String reverseStringShort(final String input)
	{
		return input.length() <= 1 ? input : reverseString(input.substring(1)) + input.charAt(0);
	}
}
