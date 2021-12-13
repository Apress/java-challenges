package ch03_recursion.intro;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Faculty
{
	public static void main(final String[] args)
	{
		System.out.println(fac(5));
		System.out.println(fac(7));
	}

	static int fac(final int n)
	{
		if (n == 1)
			return 1;

		return n * fac(n-1);
	}
}
