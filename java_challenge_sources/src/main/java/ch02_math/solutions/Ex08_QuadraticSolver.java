package ch02_math.solutions;


/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex08_QuadraticSolver {

	public static void main(final String[] args)
	{
		// brute force, three nested loops
		for (int a = 1; a < 100;a++)
		{
			for (int b = 1; b < 100; b++)
			{
				for (int c = 1; c < 100; c++)
				{
					if (a * a + b * b == c * c)
					{
						System.out.println("a = " + a + " / b = " + b + " / c = " + c);
					}

					// Alternatively using Math.pow(), but it is a double!!!
					/*
					if ((Math.pow(a,2)) + Math.pow(b,2) == Math.pow(c,2))
					{
						System.out.println("a = " + a + " / b = " + b + " / c = " + c);
					}
					 */
				}
			}
		}
	}
}
