package ch02_math.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
// Optimization from O(n3) to O(n2)
public class Ex08_QuadraticSolver2_Improved_On2
{
	private Ex08_QuadraticSolver2_Improved_On2()
	{
	}

	public static void main(final String[] args)
	{
		// nested loops
		for (int a = 1; a < 100; a++)
		{
			for (int b = 1; b < 100; b++)
			{
				final int c = (int) Math.sqrt(a * a + b * b);
				if (c < 100 && a * a + b * b == c * c)
				{
					System.out.println("a = " + a + " / b = " + b + " / c = " + c);
				}
			}
		}
	}
}
