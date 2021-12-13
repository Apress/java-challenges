package ch02_math.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex08_CubicSolver2_Improved_On3
{
	private Ex08_CubicSolver2_Improved_On3()
	{
	}

	public static void main(final String[] args)
	{
		solveCubicEquation();
	}

	private static void solveCubicEquation()
	{
		for (int a = 1; a < 100; a++)
		{
			for (int b = 1; b < 100; b++)
			{
				for (int c = 1; c < 100; c++)
				{
					final int value = a * a + b * b - c * c;
					if (value > 0)
					{
						final int d = (int) Math.sqrt(value);

						if (d < 100 && a * a + b * b == c * c + d * d)
						{
							System.out.println("a = " + a + " / b = " + b +
									" / c = " + c + " / d = " + d);
						}
					}
				}
			}
		}
	}
}
