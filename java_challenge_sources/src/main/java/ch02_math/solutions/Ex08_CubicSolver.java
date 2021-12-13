package ch02_math.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex08_CubicSolver
{
	private Ex08_CubicSolver()
	{
	}

	public static void main(final String[] args)
	{
		// brute force, nested loops
		for (int a = 1; a < 100;a++)
		{
			for (int b = 1; b < 100; b++)
			{
				for (int c = 1; c < 100; c++)
				{
					for (int d = 1; d < 100; d++)
					{
						if (a * a + b * b == c * c + d * d)
						{
							System.out.println("a = " + a + " / b = " + b + " / c = " + c + " / d = " + d);
						}
					}
				}
			}
		}
	}
}
