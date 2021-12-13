package ch02_math.intro;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class ExtractDigitsExample
{
	public static void main(final String[] args)
	{
		extractDigits(7);

		extractDigits(1234567);
	}

	private static void extractDigits(final int startValue)
	{
		int remainingValue = startValue;

		while (remainingValue > 0)
		{
			int digit = remainingValue % 10;

			System.out.print(digit + " ");

			remainingValue = remainingValue / 10;
		}

		System.out.println();
	}
}
