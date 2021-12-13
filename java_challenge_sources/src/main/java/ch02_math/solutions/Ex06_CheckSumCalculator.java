package ch02_math.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex06_CheckSumCalculator
{
	private Ex06_CheckSumCalculator()
	{
	}

	static int calcChecksum(final String input)
	{
		int crc = 0;
		for (int i = 0; i < input.length(); i++)
		{
			final char currentChar = input.charAt(i);

			if (Character.isDigit(currentChar))
			{
				final int pos = i + 1;
				final int value = (currentChar - '0') * pos;

				crc += value;
			}
		}

		return crc % 10;
	}
}
